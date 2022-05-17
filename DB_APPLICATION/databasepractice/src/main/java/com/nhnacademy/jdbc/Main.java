package com.nhnacademy.jdbc;

import com.nhnacademy.jdbc.domain.StudentRepository;
import com.nhnacademy.jdbc.domain.Teacher;
import com.nhnacademy.jdbc.domain.TeacherRepository;
import com.nhnacademy.jdbc.repository.JdbcTeacherRepository;
import com.nhnacademy.jdbc.repository.PreparedStudentRepository;
import com.nhnacademy.jdbc.repository.PreparedTeacherRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
//
//        System.out.println("==> Statement");
//        TeacherRepository teacherRepository = new JdbcTeacherRepository();
//        // findAll
//        teacherRepository.findAll().forEach(it -> System.out.println(it));
//        // findById
//        System.out.println(teacherRepository.findById(1));
//
//        // insert
//        System.out.println(teacherRepository.insert(new Teacher(4, "진융", null)));
//
//        // update
//        System.out.println(teacherRepository.updateNameById(4, "진융융"));
//
//        // delete
//        System.out.println(teacherRepository.deleteById(4));

        /**
         * 1. Optional !!
         * 2. statement를 이용한 것은 요즘 현업에서 잘 쓰이지 않는다 -> 보안도 있고.. 귀찮스
         * 3. Date 형 -> new Timestamp(new Date().getTime())
         */

//        System.out.println("==> PreparedStatement");
//        PreparedTeacherRepository preparedTeacherRepository = new PreparedTeacherRepository();
//        preparedTeacherRepository.findAll().forEach(it -> System.out.println(it));
//        System.out.println(preparedTeacherRepository.findById(2));
//
//        // insert
//        System.out.println(preparedTeacherRepository.insert(new Teacher(4, "진융", null)));
//
//        // update
//        System.out.println(preparedTeacherRepository.updateNameById(4, "진융융"));
//
//        // delete
//        System.out.println(preparedTeacherRepository.deleteById(4));


        System.out.println("==> PreparedStatement DBCP");
        PreparedTeacherRepository preparedTeacherRepository = new PreparedTeacherRepository();
        DataSource dataSource = DbUtils.getDataSource();
        Connection connection = dataSource.getConnection();

        System.out.println(preparedTeacherRepository.findAll(connection));
        System.out.println(preparedTeacherRepository.findById(connection, 2));
        System.out.println(preparedTeacherRepository.insert(connection, new Teacher(4, "진융", null)));
        System.out.println(preparedTeacherRepository.updateNameById(connection,4, "진융융"));
        System.out.println(preparedTeacherRepository.deleteById(connection, 4));


    }
}
