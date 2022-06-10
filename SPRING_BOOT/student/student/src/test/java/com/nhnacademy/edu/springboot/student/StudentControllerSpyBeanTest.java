package com.nhnacademy.edu.springboot.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 테스트 order를 정하는 방법이 있고
//@Transactional // 테스트를 한 후 rollback 하는 방법도 있다
class StudentControllerSpyBeanTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    void testGetStudents() throws Exception {
        this.mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("Manty")));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception {
        this.mockMvc.perform(get("/students/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("manty")))
                .andExpect(jsonPath("$.score", equalTo(100)));
    }

    @Test
    @Order(3)
    void testCreateStudent() throws Exception {
        Student zbum = new Student(4L, "zbum", 200);

        String requestBody = new ObjectMapper().writeValueAsString(zbum);

        this.mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(4L)));

    }

    @Test
    @Order(4)
    void testDeleteStudent() throws Exception {
        this.mockMvc.perform(delete("/students"))
                .andExpect(status().isOk());
    }
}