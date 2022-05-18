package com.nhnacademy.repository;

import java.util.List;

public interface TeacherRepository {
    Teacher findById(long id);

    List<Teacher> findAll();

    int insert(Teacher teacher);

    int deleteById(long id);
}
