package com.example.javabasic.sample.collection.sort1;

/**
 * @author chenpenghui
 * @date 2021-4-4
 */
public class Student implements Comparable<Student> {

    private String name;
    private Integer age;

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


    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
