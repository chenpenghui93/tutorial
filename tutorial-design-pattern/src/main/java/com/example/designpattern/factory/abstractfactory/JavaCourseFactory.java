package com.example.designpattern.factory.abstractfactory;

import com.example.designpattern.factory.ICourse;

/**
 * @author cph
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse createCourse() {
        return new com.example.designpattern.factory.JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createViedo() {
        return new JavaVideo();
    }
}
