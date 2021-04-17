package com.example.designpattern.proxy.gpproxy;

import com.example.designpattern.proxy.Person;
import com.example.designpattern.proxy.jdkmeipo.Customer;

/**
 * @Author cph
 * @Date 2020/1/31
 */
public class GPTest {
    public static void main(String[] args) {
        Person obj = (Person) new GPMeipo().getInstance(new Customer());
        System.out.println(obj);
        obj.findLove();
    }
}
