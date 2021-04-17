package com.example.designpattern.factory.abstractfactory;

import com.example.designpattern.factory.ICourse;

/**
 * @author cph
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse createCourse() {
        return new com.example.designpattern.factory.PythonCourse();
    }

    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createViedo() {
        return new PythonVideo();
    }
}
