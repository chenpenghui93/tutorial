package com.example.javabasic.sample.concurrent.thread;

/**
 * 实现Runnable接口方式，覆写run方法
 * 适用于无法直接extends Thread的情况
 *
 * @author chenpenghui
 * @date 2021-3-10
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);

        t1.start();
        t2.start();
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("current thread: " + Thread.currentThread().getName());
        }
    }
}
