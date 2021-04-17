package com.example.designpattern.observer.jdk9;

/**
 * @Author cph
 * @Date 2020/3/7
 */
public class Jdk9ListenerTest {
    public static void main(String[] args) {
        /*
         * 适用场景：在关联行为之间建立触发机制
         * 设计思想：jdk9版本以后的实现
         * 使用方法：
         * 1.被观察者继承PropertyChangeEvent类，
         * 2.观察者实现PropertyChangeListener接口，
         * 3.将被观察者实例作为参数传入观察者实例的propertyChange()方法
         */
        Question question = new Question();
        question.setUserName("zhangsan");
        question.setContent("如何在实践中运用设计模式");
        Community community = new Community(question, null, "1", "2");

        Admin admin = new Admin();
        admin.propertyChange(community);
    }
}
