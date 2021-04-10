package com.example.javabasic.sample.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 警示代码
 *
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(3);
        Thread thread1 = new TranslateThread("1st content", count);
        Thread thread2 = new TranslateThread("2st content", count);
        Thread thread3 = new TranslateThread("3st content", count);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            count.await(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完成");

    }
}

class TranslateThread extends Thread {
    private String content;
    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("原文存在非法字符！");
        }

        System.out.println(content + " 的翻译已经完成，译文是。。。");
        count.countDown();
    }
}
