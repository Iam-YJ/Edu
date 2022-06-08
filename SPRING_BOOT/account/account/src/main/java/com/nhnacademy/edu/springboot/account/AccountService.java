package com.nhnacademy.edu.springboot.account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();
    Account getAccount(Long id);
    Account createAccount(Account account);
    String deleteAccount(Long id);
}
