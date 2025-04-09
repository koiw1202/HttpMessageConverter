package com.example.webMvcConfigureTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebMvcConfigureTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMvcConfigureTestApplication.class, args);
    }

}
