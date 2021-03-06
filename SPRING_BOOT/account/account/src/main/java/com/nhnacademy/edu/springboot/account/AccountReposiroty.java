package com.nhnacademy.edu.springboot.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountReposiroty extends JpaRepository<Account, Long> {
    List<Account> findAll();

    Account findById();

    Account save(Account account);

    void deleteById(Long id);


}
