package com.example.webMvcConfigureTest.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.webMvcConfigureTest.web.*;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-09        koiw1       최초 생성
 */

//@EnableWebMvc
//@ComponentScan(basePackages = { "com.example.webMvcConfigureTest.web" })
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        TestHttpMessageConverter testHttpMessageConverter = new TestHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(new MediaType("*"));

        testHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);

//        converters.add(0 , testHttpMessageConverter);
    }
}


























