package com.example.javabasic.sample.concurrent.thread;

/**
 * @author chenpenghui
 * @date 2021-5-27
 */
public class InterruptDemo implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptDemo());
        t1.start();
        Thread.sleep(1000);
        // 在main线程中发送中断信号
        t1.interrupt();
    }

    @Override
    public void run() {
        // 让run()中的程序决定线程是否应该结束
        // Thread.currentThread().isInterrupted() 获取线程中断状态
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--");
        }
    }
}
