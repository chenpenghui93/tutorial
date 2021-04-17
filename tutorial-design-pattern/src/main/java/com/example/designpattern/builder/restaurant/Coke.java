package com.example.designpattern.builder.restaurant;

/**
 * @Author cph
 * @Date 2020/4/12
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
