package com.example.javabasic.sample.thread.demo;

/**
 * 继承Thread类实现多线程，覆写run方法
 * 本质上也是实现的Runnable接口
 * 启动线程的唯一方式就是Thread类的start()方法
 *
 * @author chenpenghui
 * @date 2021-3-10
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("current thread: " + Thread.currentThread().getName());
        }
    }
}
