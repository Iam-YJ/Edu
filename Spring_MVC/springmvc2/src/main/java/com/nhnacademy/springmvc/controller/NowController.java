package com.nhnacademy.springmvc.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NowController {

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("hello", "hello!!!");
//        return "index";
//    }
//
//    @GetMapping("/")
//    public String index(Map<String, String> map) {
//        map.put("hi", "hi!!!");
//        return "index";
//    }
//
//    @GetMapping("/")
//    public String index(ModelMap modelMap) {
//        modelMap.addAttribute("wow", "wow!!!");
//        return "index";
//    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("woww", "woww");
        return mav;
    }

    @GetMapping("/aaaa") // aaaa?name=xxxx
    public ModelAndView index(@RequestParam(value = "name", required = false) String name){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name", name);
        return mav;
    }

    @GetMapping("/aaaa/{userId}") // aaaa?name=xxxx
    public ModelAndView index(@PathVariable(value = "userId", required = false) int userId){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("userId", userId);
        return mav;
    }

    /*
     * GET /users/1234?filterPassword=true
     * User-Agent: Mozila
     */
    @GetMapping("/users/{userId}") // aaaa?name=xxxx
    public ModelAndView index(@PathVariable("userId") long userId,
                              @RequestParam(value = "filterPassword", required = false) boolean filterPassword,
                              @RequestHeader("User-Agent") String userAgent,
                              @CookieValue("SESSION") String sessionCookie){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

//    @PostMapping
//    public ModelAndView registerUser(@ModelAttribute UserRegisterRequest userRequest) {
//        User user = userRepository.addUser(userRequest.getId(), userRequest.getPassword(), userRequest.getAge());
//
//        ModelAndView mav = new ModelAndView("userInfo");
//        mav.addObject("user", User.constructPasswordMaskedUser(user));
//
//        return mav;
//    }

}
