package com.nhnacademy.jdbc.board.index.web;

import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.rmi.MarshalledObject;
import java.util.Optional;

@Controller
@RequestMapping
@Slf4j
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/login"})
    public String login() {
        return "index/loginForm";
    }

    @PostMapping(value = {"/login"})
    public String doLogin(@RequestParam("uname") String id,
                          @RequestParam("psw") String password,
                          HttpSession session,
                          Model model){

        Optional<User> user = userService.checkUser(id, password);
        if (!user.isEmpty()) {
            session.setAttribute("user", user.get());
            model.addAttribute("user", user.get());

            return "index/loginSuccess";
        } else {
            return "index/loginForm";
        }

    }

}
