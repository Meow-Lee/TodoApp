package com.example.TodoApp.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TimeCalculate {
    @Around("@annotation(com.example.TodoApp.aop.TimeLog)")
    public Object execTimeCalculate(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();

        stopWatch.stop();
        System.out.println(joinPoint.getSignature() + " executed in: " + stopWatch.getTotalTimeMillis() + "ms");

        return result;
    }
}
