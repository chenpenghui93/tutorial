package com.example.javabasic.sample.java8;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

/**
 * @author chenpenghui
 * @date 2020/7/19
 */
public class DoubleStreamDemo {
    public static void main(String[] args) {
        DoubleStream.of(5.33, 2.34, 5.32, 2.31, 3.51).map(d -> d * 1.5).forEach(i -> System.out.print(i + " "));
        System.out.println();
        double val = DoubleStream.of(12.1, 11.2, 13.3).average().getAsDouble();
        System.out.println(val);
        val = DoubleStream.of(12.1, 11.2, 13.3).max().getAsDouble();
        System.out.println(val);
        DoublePredicate range = d -> d > 12.11 && d < 12.99;
        DoubleStream.of(12.1, 11.2, 12.3).filter(range).forEach(d -> System.out.print(d));
    }
}
