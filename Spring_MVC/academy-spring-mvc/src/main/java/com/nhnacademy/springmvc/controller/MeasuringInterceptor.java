package com.nhnacademy.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




@Slf4j
// 이렇게 만들고 webConfig의 addInterceptor에 등록해줘야한다
public class MeasuringInterceptor implements HandlerInterceptor {
    private final StopWatch stopWatch = new StopWatch();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
//        stopWatch.start();
        // 하지만 stop watch는 이런식으로 코딩하면 안됨
        // intercept 되면서 stop watch가 공유됨
        
        // 요청 단위로 저장하고 사용하라고.. request.setAttribute()가 있다
        request.setAttribute("timeStamp", System.currentTimeMillis());
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        stopWatch.stop();

        long before = (long) request.getAttribute("timeStamp");
        long elapsed = System.currentTimeMillis()-before;

        log.error("elapsed time : {}", elapsed);
    }
}
