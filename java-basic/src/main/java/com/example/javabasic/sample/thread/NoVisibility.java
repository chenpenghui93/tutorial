package com.example.javabasic.sample.thread;

/**
 * 反例，不要这么做！
 *
 * @author cph
 * @version 1.0.0
 * @date 2019/1/16
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
