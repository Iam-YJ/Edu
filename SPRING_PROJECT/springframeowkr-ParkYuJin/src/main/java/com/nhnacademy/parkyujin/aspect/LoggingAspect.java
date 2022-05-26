package com.nhnacademy.parkyujin.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * This class was created to manage log in all services.
 */
@Aspect
@Component
public class LoggingAspect {

    public static final Log logger = LogFactory.getLog(com.nhnacademy.parkyujin.main.BootStrap.class);
    StopWatch stopWatch = new StopWatch();

    /**
     * @param
     * @return Object
     * @throws Throwable
     */
    @Around("execution(* com.nhnacademy.parkyujin.*.*.*(..))")
    public Object loggingMessage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            stopWatch.start();
            return proceedingJoinPoint.proceed();
        } finally {
            stopWatch.stop();
            logger.info("실행 메서드 : "+ "[" + proceedingJoinPoint.getSignature().getName() + "]");
            logger.info(stopWatch.prettyPrint());

        }
    }

}
