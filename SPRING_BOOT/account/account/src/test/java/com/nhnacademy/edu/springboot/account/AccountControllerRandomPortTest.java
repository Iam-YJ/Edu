package com.nhnacademy.edu.springboot.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.thymeleaf.IThrottledTemplateProcessor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerRandomPortTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testGetAccounts() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<Account>> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<List<Account>> accounts = testRestTemplate.exchange("/accounts",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<List<Account>>() {
                });

        assertThat(accounts.getBody())
                .isEqualTo(new Account(2L, "200", 200));
    }

    @Test
    void testGetAccount() throws Exception{

    }

    @Test
    void testCreateAccount() throws Exception{
        Account account = new Account(4L, "400", 400);
        this.testRestTemplate.postForEntity("/accounts", account, Account.class);
    }

    @Test
    void testDeleteAccount() throws Exception{
        this.testRestTemplate.delete("/accounts/{id}", 5L);
    }

}