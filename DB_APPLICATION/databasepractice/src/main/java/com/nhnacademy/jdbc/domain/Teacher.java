package com.nhnacademy.jdbc.domain;

import java.util.Date;

public class Teacher {

//  `id` INT(11) NOT NULL,
//  `name` VARCHAR(20) NOT NULL,
//  `created_at` DATETIME NOT NULL,

    private final int id;
    private final String name;
    private final Date createdAt;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Teacher(int id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
