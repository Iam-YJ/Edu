package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRegisterRequest;
import com.nhnacademy.springmvc.exception.UserNotFoundException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.validator.StudentRegisterRequestValidator;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    private final StudentRepository studentRepository;

    private final StudentRegisterRequestValidator validator;


    public StudentController(StudentRepository studentRepository,
                             StudentRegisterRequestValidator validator) {
        this.studentRepository = studentRepository;
        this.validator = validator;
    }

    @ModelAttribute("post")
    public Student getStudent(@PathVariable("studentId") long studentId) {
        return studentRepository.getStudent(studentId);
    }

    // Model, ModelMap, ModelAndView를 각각 최소 1번 이상 사용할 것
    @GetMapping("/{studentId}")
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String viewStudent(@ModelAttribute("student") Student student,
                              @PathVariable("studentId") long studentId,
                              Model model) {
        model.addAttribute("student", student);
        return "studentView";
    }

    @GetMapping("/{studentId}?hideScore")
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String viewStudentHideScore(@RequestParam(name = "hideScore") String answer,
                                       @ModelAttribute("student") Student student,
                                       @PathVariable("studentId") long studentId,
                                       Model model) {

        model.addAttribute("student", student);
        if(answer.equals("yes")){
            return "studentHideView";
        }
        return "studentView";
    }


    @GetMapping("/{studentId}/modify")
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String studentModifyForm(@PathVariable("studentId") long userId, ModelMap modelMap) {
        Student student = studentRepository.getStudent(userId);

        modelMap.put("student", student);
        return "studentModify";
    }

    @PostMapping("/{studentId}/modify")
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postStudentModifyForm(@Validated @ModelAttribute
                                            StudentRegisterRequest studentRegisterRequest,
                                        BindingResult bindingResult,
                                        @PathVariable("studentId") long userId,
                                        ModelAndView modelAndView) {
        Student student = studentRepository.getStudent(userId);
        Student modified = null;

//        if (Objects.isNull(student)) {
//            modelAndView.addObject("exception", new UserNotFoundException());
//            return "error";
//        }

//        Student student1 =
//            new Student(studentRegisterRequest.getName(), studentRegisterRequest.getEmail(),
//                Integer.parseInt(studentRegisterRequest.getScore()),
//                studentRegisterRequest.getComment());

        if (studentRepository.exists(userId)) {
            modified = studentRepository.modifyStudent(userId, student);
        }

        modelAndView.addObject("student", modified);
        return "studentView";
    }

    @InitBinder("studentRegisterRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

}
