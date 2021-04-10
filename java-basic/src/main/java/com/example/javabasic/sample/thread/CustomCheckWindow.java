package com.example.javabasic.sample.thread;

import java.util.concurrent.Semaphore;

/**
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class CustomCheckWindow {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 100; i++) {
            new SecurityCheckedThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckedThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckedThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("NO." + seq + "乘客，正在查验中···");

                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("NO." + seq + "乘客，身份可疑，不能出国！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("NO." + seq + "乘客，已完成服务。");
            }
        }
    }
}
