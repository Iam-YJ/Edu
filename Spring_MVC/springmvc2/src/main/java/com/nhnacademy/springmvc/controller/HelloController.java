package com.nhnacademy.springmvc.controller;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
//    @GetMapping("/")
//    public String index(){
//        // ..
//        return "index";
//    }
//
//    @GetMapping("/test")
//    public String test(){
//        return "test";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/test2")
//    public String test2(){
//        return "test2";
//    }
//
//    @RequestMapping(value="/test", params = "id=aaa")
//    public String test3(HttpServletResponse response, Map<String, String> map, ModelMap modelMap){
//        map.put("name", "dongmyo");
//        modelMap.addAttribute("name", "dongmyo");
//        // 이렇게 하고 .jsp에서 ${}로 받을 수 있다
//
//        return "test2";
//    }
}


//@Controller
//@RequestMapping("/text2")
//public class HelloController{
//    @GetMapping("/aaa") // ->/test2/aaa
////    @RequestMapping(method = RequestMethod.GET, value = "/aaa")
//    public String index(){
//        return "index";
//    }
//
//    @GetMapping
//    public String text(){
//
//    }
//}