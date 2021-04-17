package com.example.designpattern.proxy.gpproxy;

import java.lang.reflect.Method;

/**
 * @Author cph
 * @Date 2020/1/31
 */
public interface GPInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
