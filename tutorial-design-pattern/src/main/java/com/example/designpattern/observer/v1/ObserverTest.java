package com.example.designpattern.observer.v1;

/**
 * @Author cph
 * @Date 2020/2/21
 */
public class ObserverTest {

    public static void main(String[] args) {

        /*
         * 适用场景：在关联行为之间建立触发机制
         * 设计思想：jdk8以前版本的实现
         * 使用方法：
         * 1.被观察者继承Observable类，观察者实现Observer接口
         * 2.实例化被观察者、观察者，被观察者实例调用addObserver()，观察者作为入参
         * 3.被观察者调用自定义方法，发布变更
         */
        GPer gper = GPer.getInstance();
        Teacher tim = new Teacher("tim");
        Teacher mic = new Teacher("mic");

        gper.addObserver(tim);
        gper.addObserver(mic);

        Question question = new Question();
        question.setUserName("zhangsan");
        question.setContent("如何在实践中运用设计模式");

        gper.publishQuestion(gper, question);
    }
}
