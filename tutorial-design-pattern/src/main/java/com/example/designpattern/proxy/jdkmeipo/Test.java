package com.example.designpattern.proxy.jdkmeipo;

import com.example.designpattern.proxy.Person;

/**
 * @Author cph
 * @Date 2020/1/31
 */
public class Test {
    public static void main(String[] args) {
        /*
         * 适用场景：增强被代理对象，保护被代理对象
         * 设计思想：代理对象持有被代理对象的引用，利用反射动态生成代码
         * 使用方法：动态代理若要实现对被代理类的扩展，只需结合策略模式，新增策略类即可，无需修改代理类
         */
        Person obj = (Person) new JDKMeipo().getInstance(new Customer());
        obj.findLove();
    }
}
