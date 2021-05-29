package com.example.javabasic.sample.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * jps 显示当前所有java进程pid
 * jstack 17356 通过jstack pid可以打印指定java进程id的堆栈信息，进而查看线程运行状态
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
