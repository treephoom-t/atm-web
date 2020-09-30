package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
}

