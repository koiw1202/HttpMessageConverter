package com.example.webMvcConfigureTest.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return ResponseEntity.ok(data);
    }
}