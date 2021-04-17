package com.example.designpattern.proxy.staticproxy.simple;

/**
 * @Author cph
 * @Date 2020/1/30
 */
public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void findLove() {
        System.out.println("父母物色对象...");
        this.son.findLove();
        System.out.println("双方见面搞定");
    }

}
