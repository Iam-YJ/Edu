package com.nhnacademy.edu.springboot.account.config;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemController {
    private final SystemProperties systemProperties;

    @GetMapping("/system/author")
    public SystemInfo getAuthor(){
        return new SystemInfo(systemProperties.getAuthor());
    }

    @RequiredArgsConstructor
    @Getter
    static class SystemInfo{
        private final String author;
    }


}
