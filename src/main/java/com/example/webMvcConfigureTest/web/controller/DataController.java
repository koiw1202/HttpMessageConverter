package com.example.webMvcConfigureTest.web.controller;

import com.example.webMvcConfigureTest.web.constant.variable;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.el.VariableMapper;
import org.springframework.expression.spel.ast.VariableReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

        /* java.util.LinkedHashMap */
        /* java.util.ArrayList */
        StringBuilder sb = new StringBuilder();
        map.forEach( (String key, Object value) -> {

            dfs(value, sb);

//            sb.append(value);
        });
        System.out.println(sb);
//        StringBuilder sb = new StringBuilder();



//        System.out.println("sb => " + sb);

        return ResponseEntity.ok(data);
    }

    public String dfs(Object value, StringBuilder sb) {
        if(variable.checkVariable(value.getClass().getName())) {
            sb.append(value);
        } else {
            if("java.util.LinkedHashMap".equals(value.getClass().getName())) {
                Map<String, Object> tempMap = (LinkedHashMap) value;
                tempMap.forEach((String key, Object obj) -> dfs(obj,sb));
            } else if("java.util.ArrayList".equals(value.getClass().getName())) {
                List<Object> tempList = (ArrayList) value;

                for(Object obj : tempList) {
                    dfs(obj,sb);
                }
            }
        }

        return sb.toString();
    } //End of dfs


}












