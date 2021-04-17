package com.example.javabasic.sample.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 如果一个接口的实现类只需要实现一个方法，那么该接口就是函数接口
 * 1、 那些只有一个方法的接口，例如 Comparable 接口，它只有一个方法 compareTo()
 * 2、 那些具有多个默认方法，但有且只有一个虚方法的接口。也就是说，函数接口也可以有多个方法，但除了一个可用 Lambda 表达式来实现的方法，
 * 其它方法都必须有 default 关键字
 *
 * @author chenpenghui
 * @date 2020/7/25
 */
public class FunctionalInterface {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("Print all numbers:");
        eval(list, n -> true);

        System.out.println("Print even numbers:");
        eval(list, n -> n % 2 == 0);

        System.out.println("Print numbers greater than 3:");
        eval(list, n -> n > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}
