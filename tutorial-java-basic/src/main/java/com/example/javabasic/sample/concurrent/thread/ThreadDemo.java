package com.example.javabasic.sample.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenpenghui
 * @date 2021-5-27
 */
public class ThreadDemo implements Runnable {

    // 声明为实现类
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
    // 声明为接口
    ExecutorService executorService = new ThreadPoolExecutor(20, 20, 90L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

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
