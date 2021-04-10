package com.example.javabasic.utils;

import java.util.UUID;

/**
 * @author chenpenghui
 * @date 2020/8/15
 */
public class GeneratorUtil {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateUUIDNoDash(){
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }

}
