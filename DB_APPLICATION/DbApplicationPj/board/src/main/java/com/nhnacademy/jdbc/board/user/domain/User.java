package com.nhnacademy.jdbc.board.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private final String id;
    private final String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

}
