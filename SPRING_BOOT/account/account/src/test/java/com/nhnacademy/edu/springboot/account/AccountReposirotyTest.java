package com.nhnacademy.edu.springboot.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountReposirotyTest {

    @Autowired
    AccountReposiroty accountReposiroty;


    @Test
    void accountFindByIdTest(){

        Account account = new Account(1L, "2", 200);

        accountReposiroty.save(account);

        Optional<Account> findAccount = accountReposiroty.findById(1L);


        assertThat(findAccount).isPresent();
        assertThat(findAccount.orElse(null)).isEqualTo(account);

    }
    @Test
    void findAll() {
    }
}