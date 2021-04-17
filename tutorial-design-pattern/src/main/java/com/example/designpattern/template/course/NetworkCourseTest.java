package com.example.designpattern.template.course;

/**
 * @Author cph
 * @Date 2020/2/3
 */
public class NetworkCourseTest {
    public static void main(String[] args) {
        System.out.println("---java---");
        NetworkCourse java = new JavaCourse();
        java.createCourse();

        System.out.println("---bigData---");
        NetworkCourse bigData = new BigDataCourse(true);
        bigData.createCourse();
    }
}
