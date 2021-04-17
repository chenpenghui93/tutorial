package com.example.designpattern.flyweight.general;

/**
 * @author chenpenghui
 * @date 2021-3-27
 */
public class FlyweightTest {
    public static void main(String[] args) {
        IFlyweight fw1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight fw2 = FlyweightFactory.getFlyweight("bb");
        fw1.operation("a");
        fw2.operation("b");
    }
}
