package com.example.designpattern.factory.simplefactory;

import com.example.designpattern.factory.ICourse;

/**
 * @author cph
 */
public class CourseFactory {
    public ICourse create(Class clazz) {
        try {
            if (null != clazz) {
                return (ICourse) clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
