package com.nhnacademy.domain;

import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("SELECT * FROM JdbcStudents WHERE id = #{id}")
    Student selectStudent(int id);
}
