package com.example.designpattern.observer.v1;

import java.util.Observable;

/**
 * JDK实现 被观察者
 * java9中弃用：不可序列化、线程不安全、事件模型不够丰富
 * 推荐 PropertyChangeEvent + PropertyChangeListener
 *
 * @Author cph
 * @Date 2020/2/21
 */
public class GPer extends Observable {
    private static GPer gper = null;
    private String name = "生态圈";

    private GPer() {
    }

    public static GPer getInstance() {
        if (null == gper) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(GPer gper, Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了问题");
        setChanged();
        notifyObservers(question);
    }
}
