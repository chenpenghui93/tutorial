package com.example.designpattern.singleton.hungry;

/**
 * @Author cph
 * @Date 2019/12/25
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton.getInstance();
        HungryStaticSingleton.getInstance();
    }
}
