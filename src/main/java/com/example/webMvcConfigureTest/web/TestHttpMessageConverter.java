package com.example.webMvcConfigureTest.web;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-09        koiw1       최초 생성
 */
public class TestHttpMessageConverter extends AbstractHttpMessageConverter<Object> {


//    @Override
//    protected MyCustomData readInternal(Class<? extends MyCustomData> clazz, HttpInputMessage inputMessage)
//            throws IOException {
//
//        System.out.println("=================================");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputMessage.getBody()));
//
//        String line = reader.readLine();
//        String[] fields = line.split(",");
//        ByteArrayHttpMessageConverter
//        return new MyCustomData(fields); // Convert CSV line into custom object
//    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        System.out.println("111111111111111111111111111");

        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("22222222222222222222222222");
    }
}
