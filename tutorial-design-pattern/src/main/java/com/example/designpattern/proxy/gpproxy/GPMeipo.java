package com.example.designpattern.proxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @Author cph
 * @Date 2020/1/31
 */
public class GPMeipo implements GPInvocationHandler {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("invoke before。。。GP");
    }

    private void after() {
        System.out.println("invoke after。。。GP");
    }
}
