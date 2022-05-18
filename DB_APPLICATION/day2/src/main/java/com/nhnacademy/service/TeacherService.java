package com.nhnacademy.service;

import com.nhnacademy.repository.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(long id);

    List<Teacher> getAllTeachers();

    void insertAndDelete(Teacher teacher);

    void insertAndDeleteWithoutTransaction(Teacher teacher);
}
