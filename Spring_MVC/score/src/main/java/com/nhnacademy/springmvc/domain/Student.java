package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

public class Student {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    @Min(0)
    @Max(100)
    private int score;

    @Getter
    @Setter
    @NotBlank
    @Length(min = 0, max = 100)
    private String comment;

    public static Student create(String name, String email, int score, String comment) {
        return new Student(name, email, score, comment);
    }

    public Student(String name, String email, int score, String comment) {
        this.name = name;
        this.email = email;
        this.score = score;
        this.comment = comment;
    }
}
