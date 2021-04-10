package com.example.javabasic.sample.collection.sort2;

/**
 * @author chenpenghui
 * @date 2021-4-4
 */
public class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
