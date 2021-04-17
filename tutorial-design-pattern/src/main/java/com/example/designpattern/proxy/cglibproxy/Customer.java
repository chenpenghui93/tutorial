package com.example.designpattern.proxy.cglibproxy;

/**
 * CGLib代理的目标对象不需要实现任何接口
 * 它是通过动态继承目标对象实现的动态代理
 *
 * @Author cph
 * @Date 2020/1/31
 */
public class Customer {
    public void findLove() {
        System.out.println("Customer.findLove()");
    }
}
