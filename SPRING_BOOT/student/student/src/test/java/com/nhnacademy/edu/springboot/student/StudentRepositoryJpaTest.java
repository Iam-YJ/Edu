package com.nhnacademy.edu.springboot.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
//@AutoConfigureTestDatabase // 실제 db에 접근해서 테스트 가능
class StudentRepositoryJpaTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void findAll(){
        //DATA
        Student manty = new Student(1L, "manty", 100);
        testEntityManager.persist(manty);

        // TEST
        List<Student> actual =  studentRepository.findAll();
        assertThat(actual).contains(manty);
    }

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

}