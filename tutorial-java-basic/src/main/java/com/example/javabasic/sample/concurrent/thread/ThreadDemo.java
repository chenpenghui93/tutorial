package com.example.javabasic.sample.concurrent.thread;

/**
 * @author chenpenghui
 * @date 2021-5-27
 */
public class ThreadDemo implements Runnable {
    public static void main(String[] args) {

        // run()是直接调用实例方法
        // start()是由JVM中的Thread.cpp通知os进行线程创建、CPU调度进而回调run方法
        new Thread(new ThreadDemo()).start();
        System.out.println("main");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
