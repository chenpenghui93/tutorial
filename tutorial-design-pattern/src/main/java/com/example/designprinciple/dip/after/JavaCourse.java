package com.example.designprinciple.dip.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class JavaCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("学习java");
    }
}
