package com.example.designpattern.factory.abstractfactory;

/**
 * @author cph
 */
public class PythonNote implements INote {
    @Override
    public void write() {
        System.out.println("PythonNote");
    }
}
