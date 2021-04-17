package com.example.designpattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Author cph
 * @Date 2020/2/21
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String string) {
        //业务逻辑
        System.out.println("execute subscribe: " + string);
    }

}
