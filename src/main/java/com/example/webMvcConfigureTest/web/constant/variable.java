package com.example.webMvcConfigureTest.web.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-04-13        koiw1       최초 생성
 */
@AllArgsConstructor
@Getter
public enum variable {

    String("java.lang.String"), Integer("java.lang.Integer"), Double("java.lang.Double");
    private final String varNm;

    public static boolean checkVariable(String str) {

        return Arrays.stream(variable.values()).anyMatch(v -> {
            if (v.getVarNm().equals(str)) {
                return true;
            }
            return false;
        });
    }
}
