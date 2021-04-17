package com.example.designpattern.builder.course.chain;

/**
 * @author chenpenghui
 * @date 2021-3-21
 */
public class ChainTest {
    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder()
                .addName("设计模式")
                .addPpt("PPT")
                .addNote("笔记")
                .addVideo("视频")
                .addHomework("作业");

        System.out.println(builder.build());
    }
}
