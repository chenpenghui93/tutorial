package com.example.javabasic.sample.concurrent.thread;

/**
 * @author chenpenghui
 * @date 2021-5-27
 */
public class ThreadDemo implements Runnable {
    public static void main(String[] args) {
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
