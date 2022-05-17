package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.DbUtils;
import com.nhnacademy.jdbc.domain.Student;
import com.nhnacademy.jdbc.domain.StudentRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class PreparedStudentRepository implements StudentRepository {
    @Override
    public Optional<Student> findById(Long id) {
        Student student = null;
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JdbcTeachers")) {

            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery("");

            if (rs.next()) {
                student = new Student(rs.getLong("id"), rs.getString("name"), rs.getDate("created_at"));
            }

            return Optional.of(student);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public int insert(Student student) {
        return 0;
    }
}
