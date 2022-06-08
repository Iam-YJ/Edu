package com.nhnacademy.edu.springboot.account;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private Long id;
    private  String number;
    private  Integer balance;
}
