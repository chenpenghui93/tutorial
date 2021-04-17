package com.example.designpattern.singleton.lazy;

/**
 * @author cph
 * @date 2019/4/6
 */
public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();
        System.out.println("end");
    }
}