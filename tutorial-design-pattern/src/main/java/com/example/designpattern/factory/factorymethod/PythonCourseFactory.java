package com.example.designpattern.factory.factorymethod;

import com.example.designpattern.factory.ICourse;
import com.example.designpattern.factory.PythonCourse;

/**
 * @author cph
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
