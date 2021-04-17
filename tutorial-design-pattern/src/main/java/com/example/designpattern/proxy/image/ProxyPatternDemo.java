package com.example.designpattern.proxy.image;

/**
 * @Author cph
 * @Date 2020/3/16
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {

        /*
         * 适用场景：增强被代理对象，保护被代理对象
         * 设计思想：代理对象持有被代理对象的引用
         * 使用方法：静态代理中在代理对象中显式声明被代理对象，调用被代理对象的方法
         */
        Image image = new ProxyImage("test.jpg");

        image.display();
        System.out.println("");

        image.display();
    }
}
