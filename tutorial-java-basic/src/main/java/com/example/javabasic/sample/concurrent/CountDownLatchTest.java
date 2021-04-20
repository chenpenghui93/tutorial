package com.example.javabasic.sample.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 同步工具类，允许一个或多个线程一直等待，直到其它线程的操作执行完后再执行
 * 实现原理：
 * 通过计数器实现，计数器的初始值为线程数量，每当一个线程完成了自己的任务后，计数器值减1；
 * 当计数器值为0时，表示所有线程已完成任务，然后在闭锁上等待的线程就可以恢复执行任务
 *
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(2000L);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (latch != null) {
                    // 子线程执行结束时调用，通知主线程
                    latch.countDown();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(2000L);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (latch != null) {
                    // 子线程执行结束时调用，通知主线程
                    latch.countDown();
                }
            }
        }).start();

        try {
            System.out.println("等待" + latch.getCount() + "个子线程执行...");
            // 子线程启动完毕后立即调用，主线程在闭锁上等待
            latch.await();
            System.out.println("子线程执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
