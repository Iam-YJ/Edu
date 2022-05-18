package com.nhnacademy.jdbc.repository;

import com.nhnacademy.jdbc.DbUtils;
import com.nhnacademy.jdbc.domain.Teacher;
import com.nhnacademy.jdbc.domain.TeacherRepository;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedTeacherRepository implements TeacherRepository {
//    @Override
//    public Teacher findById(int teacherId) {
//        Teacher teacher = null;
//        try (Connection connection = DbUtils.getConnection();
//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM JdbcTeachers WHERE id=?")) {
//
//            statement.setInt(1, teacherId);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                teacher = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at"));
//            }
//
//            return teacher;
//        } catch (SQLException e) {
//            throw new RuntimeException();
//        }
//    }
//
//    @Override
//    public List<Teacher> findAll() {
//        List<Teacher> result = new ArrayList<>();
//
//        try (Connection connection = DbUtils.getConnection();
//             PreparedStatement statemnet = connection.prepareStatement("SELECT * FROM JdbcTeachers")) {
//
//            ResultSet rs = statemnet.executeQuery();
//
//            while (rs.next()) {
//
//                result.add(new Teacher(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at")));
//            }
//
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
//             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JdbcStudents (id, name, created_at) VALUES (?, ?, ?)")) {
//
//            preparedStatement.setInt(1, teacher.getId());
//            preparedStatement.setString(2, teacher.getName());
//            preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
//
//            rowCount = preparedStatement.executeUpdate();
//            // INSERT INTO JdbcStudents (id, name, created_at) VALUES (2, '학생2', '2022-05-14 00:00:00')
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        }
//
//        return rowCount;
//    }
//
//    @Override
//    public int updateNameById(int id, String name) {
//        int rowCount;
//        try(Connection connection = DbUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JdbcStudents SET name=? WHERE id=?");){
//
//            preparedStatement.setString(1, name);
//            preparedStatement.setInt(2, id);
//            rowCount = preparedStatement.executeUpdate();
//            // UPDATE JdbcStudents SET name='학생3' WHERE id=2
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//        return rowCount;
//    }
//
//    @Override
//    public int deleteById(int id) {
//        int rowCount;
//        try(Connection connection = DbUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JdbcStudents WHERE id=?");){
//            preparedStatement.setInt(1, id);
//            rowCount = preparedStatement.executeUpdate();
//            // DELETE FROM JdbcStudents WHERE id=2
//        }catch(SQLException e){
//            throw new RuntimeException(e);
//        }
//        return rowCount;
//    }

    @Override
    public List<Teacher> findAll(Connection con) {
        List<Teacher> result = new ArrayList<>();

        try (PreparedStatement statemnet = con.prepareStatement("SELECT * FROM JdbcTeachers")) {

            ResultSet rs = statemnet.executeQuery();

            while (rs.next()) {

                result.add(new Teacher(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at")));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher findById(Connection con, int id) {
        Teacher teacher = null;
        try (
                PreparedStatement statement = con.prepareStatement("SELECT * FROM JdbcTeachers WHERE id=?")) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                teacher = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getDate("created_at"));
            }

            return teacher;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public int updateNameById(Connection con, int id, String name) {
        int rowCount;
        try (
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE JdbcStudents SET name=? WHERE id=?");) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            rowCount = preparedStatement.executeUpdate();
            // UPDATE JdbcStudents SET name='학생3' WHERE id=2
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCount;
    }

    @Override
    public int insert(Connection con, Teacher teacher) {
        int rowCount;
        try (
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO JdbcStudents (id, name, created_at) VALUES (?, ?, ?)")) {

            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));

            rowCount = preparedStatement.executeUpdate();
            // INSERT INTO JdbcStudents (id, name, created_at) VALUES (2, '학생2', '2022-05-14 00:00:00')

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return rowCount;
    }

    @Override
    public int deleteById(Connection con, int id) {
        int rowCount;
        try (
                PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM JdbcStudents WHERE id=?");) {
            preparedStatement.setInt(1, id);
            rowCount = preparedStatement.executeUpdate();
            // DELETE FROM JdbcStudents WHERE id=2
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCount;
    }

}
