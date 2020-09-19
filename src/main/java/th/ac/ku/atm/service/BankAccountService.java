package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }
}
