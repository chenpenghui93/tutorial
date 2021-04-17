package com.example.designpattern.composite.demo.transparent;

/**
 * @author chenpenghui
 * @date 2021-3-28
 */
public class Course extends CourseComponent {

    private String name;
    private double price;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("课程：" + name + ", 价格：" + price);
    }
}
