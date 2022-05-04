package com.nhnacademy.springmvc.domain;

import lombok.Value;

@Value
public class StudentRegisterRequest {
    String id;
    String name;
    String email;
    String score;
    String comment;
}
