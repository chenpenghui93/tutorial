package com.example.designpattern.builder.restaurant;

/**
 * @Author cph
 * @Date 2020/4/12
 */
public interface Item {
    String name();

    Packing packing();

    float price();

}
