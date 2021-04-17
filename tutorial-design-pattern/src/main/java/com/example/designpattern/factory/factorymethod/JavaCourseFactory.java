package com.example.designpattern.factory.factorymethod;

import com.example.designpattern.factory.ICourse;
import com.example.designpattern.factory.JavaCourse;

/**
 * @author cph
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
