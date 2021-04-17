package com.example.designpattern.proxy.staticproxy.simple;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
