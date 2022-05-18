package com.nhnacademy.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

        String resource = "com/nhnacademy/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            // xml StudentMapper
//            Student student = session.selectOne("com.nhnacademy.StudentMapper.selectStudent", 1);
//            System.out.println(student.toString());

            // java class에서 StudentMapper
            Student mapperStudent = session.getMapper(StudentMapper.class).selectStudent(1);
            System.out.println(mapperStudent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
