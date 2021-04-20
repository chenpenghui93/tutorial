package com.example.javabasic.sample.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 同步工具类，一组线程互相等待至某个状态，然后这一组线程再同时执行，可重用
 * 实现原理：
 * 利用ReentrantLock实现线程间同步阻塞，利用Condition实现线程间通信，Condition将Object监视器方法wait()/notify()/notifyAll()分解成
 * 不同的对象，并通过这些不同对象与Lock组合使用
 *
 * @author chenpenghui
 * @date 2021-4-20
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "准备就绪，就绪线程数: " + cyclicBarrier.getNumberWaiting());
                    // 线程在指定状态前等待时调用
                    cyclicBarrier.await();
                    System.out.println("cyclicBarrier.getParties()" + cyclicBarrier.getParties());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
