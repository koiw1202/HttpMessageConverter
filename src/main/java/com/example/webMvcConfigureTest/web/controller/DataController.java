package com.example.webMvcConfigureTest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-09        koiw1       최초 생성
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @PostMapping(value = "/submit", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity handleData(@RequestBody Object data) {

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = objectMapper.convertValue(data, LinkedHashMap.class);

        StringBuilder sb = new StringBuilder();

        map.forEach( (String key, Object value) -> {
            sb.append(value);
        });

        System.out.println("sb => " + sb);

        return ResponseEntity.ok(data);
    }
}