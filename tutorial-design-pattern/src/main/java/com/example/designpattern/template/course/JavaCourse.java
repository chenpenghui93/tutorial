package com.example.designpattern.template.course;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public class JavaCourse extends NetworkCourse {
    @Override
    void checkHomeWork() {
        System.out.println("检查Java作业");
    }
}
