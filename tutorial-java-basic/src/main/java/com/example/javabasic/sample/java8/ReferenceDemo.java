package com.example.javabasic.sample.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2020/7/19
 */
public class ReferenceDemo {

    public static void main(String[] args) {
        ReferenceDemo referenceDemo = new ReferenceDemo();
        referenceDemo.run();
    }

    public static void upperAndPrint(String s) {
        System.out.print(s.toUpperCase());
    }

    public void run() {
        List<String> list = Arrays.asList("Ram", "Shyam", "Kabir");
        list.forEach(System.out::print);
        list.forEach(ReferenceDemo::upperAndPrint);
        list.forEach(this::lowerAndPrint);
    }

    public void lowerAndPrint(String s) {
        System.out.print(s.toLowerCase());
    }

}
