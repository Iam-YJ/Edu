package com.nhnacademy.edu.springboot.account.config;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhn.account")
@Data
public class SystemProperties {
    private String author;
}
