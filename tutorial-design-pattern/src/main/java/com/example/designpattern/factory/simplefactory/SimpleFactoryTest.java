package com.example.designpattern.factory.simplefactory;

import com.example.designpattern.factory.ICourse;
import com.example.designpattern.factory.JavaCourse;

/**
 * @author cph
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        //封装创建逻辑，客户端只需要调用工厂类的方法即可，简化调用逻辑
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }
}
