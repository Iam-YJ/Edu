package com.nhnacademy.edu.springboot.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AccountReposirotyJpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountReposiroty accountReposiroty;


    @Test
    void findAll() {
        Account account = new Account(1L, "100", 100);
        testEntityManager.persist(account);

        List<Account> actual = accountReposiroty.findAll();
        assertThat(actual).contains(account);
    }


    @Test
    void findById() {
        Account account = new Account(1L, "100", 100);
        testEntityManager.persist(account);

        Optional<Account> actual = accountReposiroty.findById(1L);
        assertThat(actual).isEqualTo(account);

    }

    @Test
    void save(Account account) {
        testEntityManager.persist(account);

        Optional<Account> actual = accountReposiroty.findById(1L);
        assertThat(actual).contains(account);
    }

    @Test
    void deleteById(Long id) {
        Account account = new Account(1L, "100", 100);
        testEntityManager.remove(account);

        Optional<Account> actual = accountReposiroty.findById(1L);
        assertThat(actual).isNotIn(account);

    }

}