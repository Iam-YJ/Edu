package com.nhnacademy.springmvc.validator;

import com.nhnacademy.springmvc.domain.StudentRegisterRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentRegisterRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return StudentRegisterRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "name is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "email is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "", "score is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "", "comment is empty");

        StudentRegisterRequest request = (StudentRegisterRequest) target;
        String name = request.getName();
        String email = request.getEmail();
        String score = request.getScore();
        String comment = request.getComment();

        //이름: 공백 제거 후 문자열의 길이가 0보다 커야 함
        //이메일: 이메일 형식이 맞아야 함
        //점수; 0점 이상 100점 이하
        //평가: 공백 제거 후 문자열의 길이가 0보다 크고 200보다 같거나 작아야 함

        if (name.trim().length() < 0) {
            errors.rejectValue("name", "", "name is larger than length 0");
        }

        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(!m.matches()){
            errors.rejectValue("email", "", "email is not match");
        }

        if (Integer.parseInt(score) < 0 || Integer.parseInt(score) > 100) {
            errors.rejectValue("score", "", "score is between 0 and 100");
        }

        if (comment.trim().length() <= 0 || comment.trim().length() > 200) {
            errors.rejectValue("comment", "", "comment is between 0 and 200");
        }


    }
}
