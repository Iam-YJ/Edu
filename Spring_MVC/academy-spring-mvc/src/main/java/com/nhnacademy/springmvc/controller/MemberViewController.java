package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberViewController {
    private final UserRepository userRepository;

    public MemberViewController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // contentNegotiation 사용하지 않고
    // 특정 파라미터만 우리가 받아서 처리하고 싶을 때 사용할 수 있다
    // 똑같은 기술인데 이렇게 할 수도 있다.
    @GetMapping(value = "/members/{memberId}", params = "format=html")
    public String getMemberView(@PathVariable("memberId") String memberId,
                                Model model) {
        User user = userRepository.getUser(memberId);

        model.addAttribute("user", user);
        return "userInfo";
    }
}
