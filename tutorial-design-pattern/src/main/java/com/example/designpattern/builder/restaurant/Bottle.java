package com.example.designpattern.builder.restaurant;

/**
 * @Author cph
 * @Date 2020/4/12
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
