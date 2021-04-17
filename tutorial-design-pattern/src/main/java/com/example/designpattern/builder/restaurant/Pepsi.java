package com.example.designpattern.builder.restaurant;

/**
 * @Author cph
 * @Date 2020/4/12
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
