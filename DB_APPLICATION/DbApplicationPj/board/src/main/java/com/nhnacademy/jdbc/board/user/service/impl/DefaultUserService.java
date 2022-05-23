package com.nhnacademy.jdbc.board.user.service.impl;

import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {
    private final UserMapper userMapper;

    public DefaultUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> getUser(String id) {
        return userMapper.selectUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public Optional<User> checkUser(String id, String password) {

        Optional<User> user = userMapper.selectUser(id);

        if (user.get().getId().equals(id) && user.get().getPassword().equals(password)) {
            return user;
        }
        else {
            return Optional.empty();
        }
    }
}