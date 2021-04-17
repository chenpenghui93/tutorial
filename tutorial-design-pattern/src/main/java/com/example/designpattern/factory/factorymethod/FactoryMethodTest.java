package com.example.designpattern.factory.factorymethod;

import com.example.designpattern.factory.ICourse;

/**
 * @author cph
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory javaCourseFactory = new JavaCourseFactory();
        ICourse javaCourse = javaCourseFactory.create();
        javaCourse.record();

        ICourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse pythonCourse = pythonCourseFactory.create();
        pythonCourse.record();
    }
}
