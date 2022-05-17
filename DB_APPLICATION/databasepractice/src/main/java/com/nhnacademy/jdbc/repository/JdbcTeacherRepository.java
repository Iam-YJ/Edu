package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.DbUtils;
import com.nhnacademy.jdbc.domain.Teacher;
import com.nhnacademy.jdbc.domain.TeacherRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;

public class JdbcTeacherRepository implements TeacherRepository {
//    @Override
//    public Teacher findById(int teacherId) {
//        Teacher teacher = null;
//        try (Connection connection = DbUtils.getConnection();
//             Statement statement = connection.createStatement()) {
//
//            ResultSet rs = statement.executeQuery("SELECT * FROM JdbcTeachers");
//
//            rs.next();
//            teacher = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at"));
//
//            return teacher;
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    @Override
//    public List<Teacher> findAll() {
//
//        List<Teacher> result = new ArrayList<>();
//
//        try (Connection connection = DbUtils.getConnection();
//             Statement statemnet = connection.createStatement()) {
//
//            ResultSet rs = statemnet.executeQuery("SELECT * FROM JdbcTeachers");
//
//            while (rs.next()) {
//                result.add(new Teacher(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at")));
//
//            }
//            return result;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public int insert(Teacher teacher) {
//        int rowCount;
//        try (Connection connection = DbUtils.getConnection();
//             Statement statement = connection.createStatement();) {
//
//            rowCount = statement.executeUpdate("INSERT INTO JdbcTeachers (id, name, created_at) " +
//                    "VALUES (" + teacher.getId() + ", \'" + teacher.getName() + "\' , \'" + new Timestamp(new Date().getTime()) + "\')");
//            // INSERT INTO JdbcStudents (id, name, created_at) VALUES (2, '학생2', '2022-05-14 00:00:00')
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return rowCount;
//    }
//
//    @Override
//    public int updateNameById(int id, String name) {
//        int rowCount;
//        try (Connection connection = DbUtils.getConnection();
//             Statement statement = connection.createStatement();) {
//            rowCount = statement.executeUpdate("UPDATE JdbcTeachers SET name= \'" + name + "' WHERE id=" + id);
//            // UPDATE JdbcStudents SET name='학생3' WHERE id=2
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return rowCount;
//    }
//
//    @Override
//    public int deleteById(int id) {
//        int rowCount;
//        try (Connection connection = DbUtils.getConnection();
//             Statement statement = connection.createStatement();) {
//            rowCount = statement.executeUpdate("DELETE FROM JdbcTeachers WHERE id=" + id);
//            // DELETE FROM JdbcStudents WHERE id=2
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return rowCount;
//    }

    @Override
    public List<Teacher> findAll(Connection con) {
        return null;
    }

    @Override
    public Teacher findById(Connection con, int id) {
        return null;
    }

    @Override
    public int updateNameById(Connection con, int id, String name) {
        return 0;
    }

    @Override
    public int insert(Connection con, Teacher teacher) {
        return 0;
    }

    @Override
    public int deleteById(Connection con, int id) {
        return 0;
    }
}
