package com.example.designpattern.factory.abstractfactory.shape;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}
