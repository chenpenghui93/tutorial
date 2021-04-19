package com.example.javabasic.sample.concurrent.volatility;

/**
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int NUMBER = 100000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class) {
                count++;
            }
        }

        while (subtractThread.isAlive()) {
        }

        System.out.println("count最终值： " + count);
    }

    public static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class) {
                    count--;
                }
            }
        }
    }
}
