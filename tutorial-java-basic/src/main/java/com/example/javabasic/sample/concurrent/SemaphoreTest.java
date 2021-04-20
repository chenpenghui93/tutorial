package com.example.javabasic.sample.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量，用于接口限流，控制并发数量
 * 实现原理：
 * 基于AQS的共享锁实现
 *
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {

                    semaphore.tryAcquire();
                    semaphore.isFair();

                    semaphore.acquire();
                    System.out.println("线程" + Thread.currentThread().getName() + "获得许可，当前已用：" + semaphore.drainPermits() + "，当前可用: " + semaphore.availablePermits());
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("线程" + Thread.currentThread().getName() + "释放许可");
                }
            }).start();
        }
    }
}
