package com.nhnacademy.edu.springboot.student;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class StudentControllerRandomPortTest {

    @Autowired
    private TestRestTemplate restTemplate;

//    @LocalServerPort
//    private Integer randomPort;

    @Test
    void testGetStudents() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<List<Student>> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<List<Student>> students = restTemplate.exchange("/students",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<List<Student>>() {

                });

        assertThat(students.getBody())
                .isEqualTo(new Student(1L, "manty", 100));
    }

    @Test
    void testGetStudent() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<Student> student = restTemplate.exchange("/student",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<Student>() {

                });

//        ResponseEntity<Student> student = restTemplate.getForEntity("/students/{id}",
//                )

        assertThat(student.getBody())
                .isEqualTo(new Student(1L, "manty", 100));
    }

    @Test
    void testCreateStudent() throws Exception {
        Student zbum = new Student(5L, "zbum", 1000);
        this.restTemplate.postForEntity("/students", zbum, Student.class);
    }


    @Test
    void testDeleteStudent() throws Exception {
        this.restTemplate.delete("/students/{id}", 5L);
    }

}