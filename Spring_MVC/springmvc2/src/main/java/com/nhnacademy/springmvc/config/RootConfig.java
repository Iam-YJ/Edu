package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.controller.ControllerBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration  // @Component의 일종이다 (stereo type의 bean 중에 하나)
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = @ComponentScan.Filter(Controller.class)) // @ComponentScan은 stereo type의 bean을 잡아서 알아서 설정해준다
// 어노테이션 말고
// ControllerBase.class로 해도 되나요?
public class RootConfig {
}
