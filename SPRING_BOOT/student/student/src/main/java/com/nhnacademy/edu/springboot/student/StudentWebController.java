package com.nhnacademy.edu.springboot.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class StudentWebController {
    private final StudentService studentService;
    @GetMapping("/web/students/{id}")
    public String getStudents(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudent(id));
        return "student";
    }
}
