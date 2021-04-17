package com.example.designpattern.observer.jdk9;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * 观察者
 *
 * @Author cph
 * @Date 2020/3/7
 */
public class Admin implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Question question = (Question) evt.getSource();
        System.out.println("用户:：" + question.getUserName() + "，问题：" + question.getContent());
        System.out.println(evt.getPropertyName());
        System.out.println(evt.getOldValue());
        System.out.println(evt.getNewValue());
    }
}
