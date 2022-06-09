package com.nhnacademy.edu.springboot.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountWebController {

    private final AccountService accountService;

    @GetMapping("/web/account/{id}")
    public String showAccount(@PathVariable Long id, Model model){
        model.addAttribute("account", accountService.getAccount(id));
        return "account";
    }

    @GetMapping("/web/account")
    public String showAccounts(){
        return "accounts";
    }


}
