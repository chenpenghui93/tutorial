package com.example.javabasic.utils.generator;

import java.util.UUID;

/**
 * UUIDGenerator
 *
 * @author chenpenghui
 * @date 2020/4/22
 */
public class UUIDGenerator {

    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static void main(String[] args) {
        String s = generateUUID();
        System.out.println(s);
        s = s.replace("-", "");
        System.out.println(s);
    }
}
