package com.nhnacademy.edu.springboot.student;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
//@NoArgsConstructor // entity로 만들 때는 생성자에 args가 없는게 필요하다
@AllArgsConstructor
public class Student {
    @Id
    private Long id;
    private String name;
    private int score;
}


