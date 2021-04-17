package com.example.designpattern.singleton.threadlocal;

import com.example.designpattern.singleton.lazy.ExecutorThread;

/**
 * @author cph
 * @date 2019/4/29
 */
public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();

        System.out.println("end");
    }
}