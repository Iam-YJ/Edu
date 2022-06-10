package com.nhnacademy.edu.springboot.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class AccountControllerMockBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountReposiroty accountReposiroty;

    @Test
    void testGetAuthor() throws Exception {
        given(accountReposiroty.findAll())
                .willReturn(List.of(new Account(100L, "900", 900)));

        this.mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].number", equalTo(900)));
    }

    @Test
    void testGetAccount() throws Exception {
        given(accountReposiroty.findAll())
                .willReturn(List.of(new Account(100L, "900", 900)));

        this.mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].number", equalTo(900)));

    }

    @Test
    void testCreateAccount() throws Exception {
        Account account = new Account(10L, "10", 10);
        given(accountReposiroty.save(account));


        String requestBody = new ObjectMapper().writeValueAsString(account);
        this.mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(10L)));

    }

    @Test
    void testDeleteAccount() throws Exception {
        willDoNothing().given(accountReposiroty).deleteById(any());

        this.mockMvc.perform(delete("/accounts/{id}", 4L))
                .andExpect(status().isOk());
    }
}