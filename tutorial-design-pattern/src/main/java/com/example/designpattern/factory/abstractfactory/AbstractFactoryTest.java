package com.example.designpattern.factory.abstractfactory;

/**
 * @author cph
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        ICourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createCourse().record();
        javaCourseFactory.createNote().write();
        javaCourseFactory.createViedo().make();

        ICourseFactory pythonCourseFactory = new PythonCourseFactory();
        pythonCourseFactory.createCourse().record();
        pythonCourseFactory.createNote().write();
        pythonCourseFactory.createViedo().make();
    }
}
