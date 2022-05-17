package com.nhnacademy.jdbc.domain;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(Long id);

    List<Student> findAll();

    int insert(Student student);
}
