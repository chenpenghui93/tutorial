package com.example.javabasic.sample.collection.sort1;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author chenpenghui
 * @date 2021-4-4
 */
public class Test1 {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("aa", 20));
        set.add(new Student("bb", 18));
        set.add(new Student("cc", 28));
        set.add(new Student("dd", 25));

        for (Student s : set) {
            System.out.println(s);
        }

    }
}
