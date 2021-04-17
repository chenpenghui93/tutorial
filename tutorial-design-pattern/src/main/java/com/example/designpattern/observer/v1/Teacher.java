package com.example.designpattern.observer.v1;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author cph
 * @Date 2020/2/21
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        System.out.println("=================");
        System.out.println(name + ", 您好，" + "社区：" + gper.getName()
                + "，学员：" + question.getUserName() + "，提问：" + question.getContent());
    }
}
