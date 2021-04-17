package com.example.designpattern.flyweight.jdk;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(127);
        Integer b = 127;
        Integer c = Integer.valueOf(128);
        Integer d = 128;
        int e = 129;
        Integer f = Integer.valueOf(129);

        // true 缓存 -128~127
        System.out.println(a == b);
        // false 缓存 -128~127
        System.out.println(c == d);
        // true 自动拆箱
        System.out.println(e == f);
    }
}
