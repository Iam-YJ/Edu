package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.DbUtils;
import com.nhnacademy.jdbc.domain.Student;
import com.nhnacademy.jdbc.domain.StudentRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;


public class JdbcStudentRepository implements StudentRepository {
    @Override
    public Optional<Student> findById(Long id) {
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcUsers");

            if (rs.next()) {
                return Optional.of(new Student(rs.getLong("id"), rs.getString("name"), rs.getDate("created_at")));
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public int insert(Student student) {
        int rowCount;
        try (Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            rowCount = statement.executeUpdate("INSERT INTO JdbcStudents (id, name, created_at) " +
                    "VALUES(" + student.getId() + ", " + student.getName() + " ," + null + " )");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCount;
    }

}
