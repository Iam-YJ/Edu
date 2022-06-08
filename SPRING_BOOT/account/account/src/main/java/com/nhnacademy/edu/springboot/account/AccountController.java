package com.nhnacademy.edu.springboot.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    Account getAccount(Long id){
        return accountService.getAccount(id);
    }

    Account createAccount(Account account){
        return accountService.createAccount(account);
    }

    String deleteAccount(Long id){
        return accountService.deleteAccount(id);
    }
}
