package com.nhnent.edu.springboot.eduspringbootdevtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("/")
    public String hello(Map<String, Object> model) {
        model.put("message", "Hi, Korea~!!~");
        return "index";
    }
}
