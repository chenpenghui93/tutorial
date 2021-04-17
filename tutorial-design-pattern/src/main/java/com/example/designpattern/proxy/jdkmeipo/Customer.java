package com.example.designpattern.proxy.jdkmeipo;

import com.example.designpattern.proxy.Person;

/**
 * @Author cph
 * @Date 2020/1/31
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("Customer.findLove()");
    }
}
