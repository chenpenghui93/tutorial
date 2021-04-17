package com.example.designpattern.builder.course.simple;

/**
 * @author chenpenghui
 * @date 2021-3-21
 */
public class SimplelTest {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("design pattern");
        builder.addPpt("ppt");
        builder.addVideo("video");
        builder.addNote("note");
        builder.addHomework("homework");

        System.out.println(builder.build());
    }
}
