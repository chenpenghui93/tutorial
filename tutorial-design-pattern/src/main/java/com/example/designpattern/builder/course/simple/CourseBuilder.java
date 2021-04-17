package com.example.designpattern.builder.course.simple;

/**
 * @author chenpenghui
 * @date 2021-3-21
 */
public class CourseBuilder {

    private Course course = new Course();

    public Course build() {
        return course;
    }

    public void addName(String name) {
        course.setName(name);
    }

    public void addPpt(String ppt) {
        course.setPpt(ppt);
    }

    public void addVideo(String Video) {
        course.setVideo(Video);
    }

    public void addNote(String Note) {
        course.setNote(Note);
    }

    public void addHomework(String Homework) {
        course.setHomework(Homework);
    }

}
