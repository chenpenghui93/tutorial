package com.example.designpattern.delegate.simple;

/**
 * @author cph
 * @date 2019/7/18
 */
public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("B擅长测试，执行" + command);
    }
}
