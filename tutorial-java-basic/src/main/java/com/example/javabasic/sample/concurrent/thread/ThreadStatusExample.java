package com.example.javabasic.sample.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * jps 查看java进程
 * jstack 17356 查看java进程日志
 *
 * @author chenpenghui
 * @date 2021-5-27
 */
public class ThreadStatusExample {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "TIME_WAITING").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusExample.class) {
                    try {
                        ThreadStatusExample.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "WAITING");

        new Thread(new BlockDemo(), "BLOCKED-DEMO-01").start();
        new Thread(new BlockDemo(), "BLOCKED-DEMO-02").start();
    }

    static class BlockDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
