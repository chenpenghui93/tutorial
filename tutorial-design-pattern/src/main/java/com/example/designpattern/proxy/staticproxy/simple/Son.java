package com.example.designpattern.proxy.staticproxy.simple;

import com.example.designpattern.proxy.Person;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class Son implements Person {

    @Override
    public void findLove() {
        System.out.println("儿子要求：大长腿");
    }
}
