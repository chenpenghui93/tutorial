package com.example.javabasic.sample.concurrent.volatility;

/**
 * start-thread 修改变量
 * check-thread 访问变量
 * 验证线程间 变量的可访问性
 *
 * @author chenpenghui
 * @date 2021-4-23
 */
public class VolatileTest {

    boolean started = false;

    public static void main(String[] args) {

        VolatileTest v = new VolatileTest();

        Thread startThread = new Thread(() -> {
            v.startSystem();
        });
        startThread.setName("start-thread");

        Thread checkThread = new Thread(() -> {
            for (int i = 0; i < 20; ++i) {
                System.out.println("loop check...");
                v.checkStatus();
            }
        });
        checkThread.setName("check-thread");

        startThread.start();
        checkThread.start();
    }

    public void startSystem() {
        System.out.println(Thread.currentThread().getName() + " begin to start, time: " + System.currentTimeMillis());
        started = true;
        System.out.println(Thread.currentThread().getName() + " started, time: " + System.currentTimeMillis());
    }

    public void checkStatus() {
        if (started) {
            System.out.println("system is running... time: " + System.currentTimeMillis());
        } else {
            System.out.println("system is not running... time: " + System.currentTimeMillis());
        }
    }


}
