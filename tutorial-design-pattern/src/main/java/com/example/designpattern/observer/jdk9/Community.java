package com.example.designpattern.observer.jdk9;

import java.beans.PropertyChangeEvent;

/**
 * 被观察者
 *
 * @Author cph
 * @Date 2020/3/7
 */
public class Community extends PropertyChangeEvent {

    public Community(Object source, String propertyName, Object oldValue, Object newValue) {
        super(source, propertyName, oldValue, newValue);
    }

}
