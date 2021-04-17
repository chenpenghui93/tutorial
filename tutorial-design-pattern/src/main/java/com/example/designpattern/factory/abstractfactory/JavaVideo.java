package com.example.designpattern.factory.abstractfactory;

/**
 * @author cph
 */
public class JavaVideo implements IVideo {
    @Override
    public void make() {
        System.out.println("JavaVideo");
    }
}
