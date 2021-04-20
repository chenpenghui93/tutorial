package com.example.javabasic.sample.concurrent;

import java.util.concurrent.Exchanger;

/**
 * Exchanger 提供一个同步点，在这个同步点的两个线程可以交换数据(成对的线程使用exchange方法)
 *
 * @author chenpenghui
 * @date 2021-4-20
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        String str1 = "james";
        String str2 = "jack";
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "修改前：" + str1);
                String exchange = exchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName() + "修改后：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "修改前：" + str2);
                String exchange = exchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName() + "修改后：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
    }

}
