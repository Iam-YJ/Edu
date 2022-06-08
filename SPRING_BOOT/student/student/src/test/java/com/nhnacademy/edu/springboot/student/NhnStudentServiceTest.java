package com.nhnacademy.edu.springboot.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhnStudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void getStudents() {
        List<Student> students = studentService.getStudents();

        assertThat(students).hasSize(2);
    }
}