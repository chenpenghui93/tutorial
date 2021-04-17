package com.example.designpattern.composite.demo.transparent;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class Test {
    public static void main(String[] args) {
        CourseComponent javaBase = new Course("Java入门课程", 8280.0);
        CourseComponent ai = new Course("人工智能", 5000.0);

        CourseComponent packageCourse = new CoursePackage("Java架构师课程", 2);

        CourseComponent design = new Course("Java设计模式", 1500.0);
        CourseComponent source = new Course("源码分析", 2000.0);
        CourseComponent softSkill = new Course("软技能", 3000.0);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softSkill);

        CourseComponent catalog = new CoursePackage("课程主目录", 1);
        catalog.addChild(javaBase);
        catalog.addChild(ai);
        catalog.addChild(packageCourse);

        catalog.print();

    }
}
