package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.UserNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import java.util.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student" )
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Model, ModelMap, ModelAndView를 각각 최소 1번 이상 사용할 것
    @GetMapping("/{studentId}" )
    public String viewStudent(@ModelAttribute("student") Student student,
                              @PathVariable("studentId") long studentId,
                              Model model) {
        if(Objects.isNull(studentId)){
            model.addAttribute("exception", new UserNotFoundException());
            return "error";
        }

        model.addAttribute("student", student);
        return "studentView";
    }


    @GetMapping("/{studentId}/modify")
    public String studentModifyForm(@ModelAttribute("student") Student student,
                                    ModelMap modelMap) {
        if(Objects.isNull(student)){
            modelMap.put("exception", new UserNotFoundException());
            return "error";
        }
        modelMap.put("student", student);
        return "studentModify";
    }

    @PostMapping("/{studentId}/modify")
    public String modifyUser() {
        return "studentView";
    }

}
