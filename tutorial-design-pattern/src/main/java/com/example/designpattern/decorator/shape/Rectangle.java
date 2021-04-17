package com.example.designpattern.decorator.shape;

/**
 * @Author cph
 * @Date 2020/3/14
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
