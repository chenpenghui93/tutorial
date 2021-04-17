package com.example.javabasic.sample.generic;

import java.util.ArrayList;

/**
 * @Author cph
 * @Date 2020/1/19
 */
public class RuntimeExceptionTest {
    public static void main(String[] args) {
        //示例：不使用泛型可能导致的运行时异常
        ArrayList al = new ArrayList();
        al.add("hello");
        al.add("world");
        //编译可以通过
        al.add(10);
        String s1 = (String) al.get(0);
        String s2 = (String) al.get(1);
        //产生运行时错误
        String s3 = (String) al.get(2);


    }
}
