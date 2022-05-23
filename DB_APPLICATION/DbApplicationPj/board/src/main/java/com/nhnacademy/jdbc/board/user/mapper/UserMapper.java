package com.nhnacademy.jdbc.board.user.mapper;

import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> selectUser(String id);

    List<User> selectUsers();

    String getUserId(String id);

    String getUserPassword(String id);

    User checkUser(String id, String password);


}
