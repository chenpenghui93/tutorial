package com.example.designpattern.factory.abstractfactory;

/**
 * @author cph
 */
public class PythonVideo implements IVideo {
    @Override
    public void make() {
        System.out.println("PythonVideo");
    }
}
