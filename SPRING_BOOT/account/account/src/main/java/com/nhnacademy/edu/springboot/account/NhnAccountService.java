package com.nhnacademy.edu.springboot.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhnAccountService implements AccountService {
    private final AccountReposiroty accountReposiroty;

    @Override
    public List<Account> getAccounts() {
        return accountReposiroty.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountReposiroty.findById(id).orElseThrow();
    }

    @Override
    public Account createAccount(Account account) {
        if (!accountReposiroty.findById(account.getId()).isEmpty()) {
            throw new IllegalStateException("already exists");
        }

        return accountReposiroty.save(account);
    }

    @Override
    public String deleteAccount(Long id) {
        accountReposiroty.deleteById(id);
        return "{" + "result"+"\"" +":" +"\"" +"OK"+"\""+'}';
    }
}
