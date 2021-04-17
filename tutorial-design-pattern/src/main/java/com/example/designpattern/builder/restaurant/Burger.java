package com.example.designpattern.builder.restaurant;

/**
 * @Author cph
 * @Date 2020/4/12
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
