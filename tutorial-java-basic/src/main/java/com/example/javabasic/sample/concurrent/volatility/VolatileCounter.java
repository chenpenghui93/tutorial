package com.example.javabasic.sample.concurrent.volatility;

import java.util.concurrent.CountDownLatch;

/**
 * volatile不能保证原子性，
 *
 * @author chenpenghui
 * @date 2021-4-25
 */
public class VolatileCounter {

    static CountDownLatch countDownLatch = new CountDownLatch(30);
    private static volatile int num = 0;

    public static void main(String[] args) throws Exception {
        // 开启30个线程累加
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    // num++不是原子性的操作
                    // 1.从主存中读取最新num值，在CPU中存一份副本值
                    // 2.对CPU中num的副本值+1
                    // 3。赋值，将CPU中最新的副本值刷新至主存
                    num++;
                }
                countDownLatch.countDown();
            }).start();
        }
        // 等待计算线程执行完毕
        countDownLatch.await();
        // 预期值=300000，实际值<300000
        System.out.println(num);
    }
}
