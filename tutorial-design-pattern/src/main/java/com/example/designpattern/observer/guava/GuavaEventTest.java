package com.example.designpattern.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @Author cph
 * @Date 2020/2/21
 */
public class GuavaEventTest {
    public static void main(String[] args) {
        /*
         * 适用场景：在关联行为之间建立触发机制
         * 设计思想：guava实现
         * 使用方法：
         * 1.观察者实例的方法上添加@Subscribe注解
         * 2.实例化EventBus、观察者类
         * 3.观察者类实例作为参数，调用EventBus实例的register()注册
         * 4.调用EventBus实例的post()发布变更
         */
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("tim");
    }
}
