package com.example.javabasic.sample.collection.sort2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-4-4
 */
public class Test2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("aa", 20));
        list.add(new Student("bb", 18));
        list.add(new Student("cc", 28));
        list.add(new Student("dd", 25));

//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge().compareTo(o2.getAge());
//            }
//        });

//        Collections.sort(list, (o1, o2) -> o1.getAge().compareTo(o2.getAge()));

        Collections.sort(list, Comparator.comparing(Student::getAge));

        for (Student s : list) {
            System.out.println(s);
        }
        ;
    }
}
