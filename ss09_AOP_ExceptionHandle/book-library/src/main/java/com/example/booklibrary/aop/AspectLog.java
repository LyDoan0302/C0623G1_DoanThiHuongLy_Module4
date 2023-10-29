package com.example.booklibrary.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
public class AspectLog {
    @Pointcut("within(com.example.booklibrary.controller.*)")
    public void allMethodPointCut(){}

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("Start method name: "+" "+
                joinPoint.getSignature().getName()+" " +
                "Time: " + LocalDateTime.now());
    }

    @After("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.out.println("End method name: "+" "+
                joinPoint.getSignature().getName()+
                " Time: " + LocalDateTime.now());

    }

}
