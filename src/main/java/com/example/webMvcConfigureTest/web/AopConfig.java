package com.example.webMvcConfigureTest.web;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-10        koiw1       최초 생성
 */
@Component
@Aspect
@RequiredArgsConstructor
public class AopConfig {

    @Pointcut("  execution (* com.example.webMvcConfigureTest.web.controller..*(..))")
    public void range() {}

    @Around("range()")
    public Object aopTest(ProceedingJoinPoint joinPoint) throws Throwable {

//        System.out.println("11 => " + joinPoint.getSignature().toShortString());
//        System.out.println("22 => " + joinPoint.getSignature().toString());

        Object result = joinPoint.proceed();

        return result;

    }


}
