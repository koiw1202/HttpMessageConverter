package com.example.webMvcConfigureTest.web;

import com.example.webMvcConfigureTest.web.abstractAop.AbstractAdvice;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt.AnnotationConfigApplicationContext;

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

    private List<AbstractAdvice> abstractAdviceList;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void getAbstractAdvice() {
        this.abstractAdviceList = new ArrayList<>();

        String[] beanNames = applicationContext.getBeanNamesForType(AbstractAdvice.class);

        for(String str : beanNames) {
            abstractAdviceList.add(applicationContext.getBean(str, AbstractAdvice.class));
        }
    }

    @Pointcut("  execution (* com.example.webMvcConfigureTest.web.controller..*(..))")
    public void range() {}

    @Around("range()")
    public Object aopTest(ProceedingJoinPoint joinPoint) throws Throwable {

        abstractAdviceList.stream().forEach(v -> {
            v.doProcess();
        });

        Object result = joinPoint.proceed();

        return result;

    }


}
