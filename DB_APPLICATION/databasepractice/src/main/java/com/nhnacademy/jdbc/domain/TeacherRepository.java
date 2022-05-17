package com.nhnacademy.jdbc.domain;

import java.sql.Connection;
import java.util.List;

public interface TeacherRepository {

//    Teacher findById(int teacherId);
//    List<Teacher> findAll();
//    int insert(Teacher teacher);
//    int updateNameById(int id, String name);
//    int deleteById(int id);

    List<Teacher> findAll(Connection con);
    Teacher findById(Connection con, int id);
    int updateNameById(Connection con, int id, String name);
    int insert(Connection con, Teacher teacher);
    int deleteById(Connection con, int id);
}
