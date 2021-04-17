package com.example.designpattern.factory.abstractfactory.shape;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
