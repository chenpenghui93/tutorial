package com.example.designpattern.factory.abstractfactory.shape;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}
