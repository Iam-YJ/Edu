package com.nhnacademy.edu.springboot.student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(Long id);
    Student createStudent(Student student);
    void deleteStudent(Long id);
}
