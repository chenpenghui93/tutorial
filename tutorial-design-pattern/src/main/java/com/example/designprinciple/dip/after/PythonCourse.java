package com.example.designprinciple.dip.after;

/**
 * @author cph
 * @date 2019/11/16
 */
public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("学习Python");
    }
}
