package com.example.designpattern.factory.abstractfactory.shape;

/**
 * @Description
 * @Author cph
 * @Date 2020/3/28
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
