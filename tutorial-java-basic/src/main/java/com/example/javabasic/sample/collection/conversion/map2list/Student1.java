package com.example.javabasic.sample.collection.conversion.map2list;

/**
 * @Author cph
 * @Date 2020/1/12
 */
public class Student1 {
    Long id;
    String name1;
    int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student1(){}

    public Student1(Long id, String name1, int score) {
        this.id = id;
        this.name1 = name1;
        this.score = score;
    }
}
