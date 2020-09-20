package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.data.CustomerRepository;
import th.ac.ku.atm.model.Customer;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        String hashPin = hash(customer.getPin());
        customer.setPin(hashPin);
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }

    private Customer findCustomer(int id) {
        try {
            return customerRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer checkPin(Customer inputCustomer) {
        Customer storedCustomer = findCustomer(inputCustomer.getId());
        if (storedCustomer != null) {
            String hashPin = storedCustomer.getPin();
            if (BCrypt.checkpw(inputCustomer.getPin(), hashPin))
                return storedCustomer;
        }
        return null;
    }
}
