package com.nhnacademy.edu.springboot.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentRepository() {
        Student manty = new Student(1L, "manty", 100);
        studentRepository.save(manty);

        Optional<Student> student = studentRepository.findById(1L);

        //Assertion
        assertThat(student).isPresent();
        assertThat(student.orElse(null)).isEqualTo(manty);
        //student 클래스에 @EqualsAndHashCode가 있기 때문에
        // 값이 같으면 true 반환

    }

    @Test
    void findAll() {
    }
}