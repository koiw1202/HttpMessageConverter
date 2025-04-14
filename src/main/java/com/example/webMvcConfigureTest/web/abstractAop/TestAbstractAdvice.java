package com.example.webMvcConfigureTest.web.abstractAop;

import org.springframework.stereotype.Component;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-14        koiw1       최초 생성
 */

@Component
public class TestAbstractAdvice implements AbstractAdvice {

    @Override
    public void doProcess() {
        System.out.println("111111111111111111111111");
    }
}
