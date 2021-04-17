package com.example.javabasic.sample.java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @author chenpenghui
 * @date 2020/7/19
 */
public class Base64Demo {
    public static void main(String[] args) {
        try {
            //encodeToString
            String base64EncodedString = Base64.getEncoder()
                    .encodeToString("Java 8 Base64 编解码 - Java 8 新特性".getBytes("utf-8"));
            System.out.println(base64EncodedString);
            //getDecoder().decode()
            byte[] base64DecodedBytes = Base64.getDecoder().decode(base64EncodedString);
            System.out.println(new String(base64DecodedBytes, "utf-8"));

            System.out.println();

            //getUrlEncoder
            String base64EncodedURLString = Base64.getUrlEncoder()
                    .encodeToString("Java 8 Base64 编解码 - Java 8 新特性".getBytes("utf-8"));
            System.out.println(base64EncodedURLString);
            //getUrlDecoder().decode()
            byte[] base64DecodedURLBytes = Base64.getUrlDecoder().decode(base64EncodedString);
            System.out.println(new String(base64DecodedURLBytes, "utf-8"));

            System.out.println();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            //getMimeEncoder().encodeToString()
            System.out.println(stringBuilder.toString());
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder(32, "@~@\n".getBytes("utf8")).encodeToString(mimeBytes);
            System.out.println(mimeEncodedString);
            //getMimeDecoder().decode()
            byte[] mimeDecodedBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
            System.out.println(new String(mimeDecodedBytes, "utf-8"));


        } catch (UnsupportedEncodingException e) {
            System.out.println("异常：" + e.getMessage());
        }
    }
}
