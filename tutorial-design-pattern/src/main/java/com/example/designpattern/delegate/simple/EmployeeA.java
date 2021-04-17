package com.example.designpattern.delegate.simple;

/**
 * @author cph
 * @date 2019/7/18
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("A擅长编码，执行" + command);
    }
}
