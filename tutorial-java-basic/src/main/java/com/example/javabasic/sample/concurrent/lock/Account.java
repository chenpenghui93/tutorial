package com.example.javabasic.sample.concurrent.lock;

/**
 * https://mp.weixin.qq.com/s/Vtqf72-15M8Uditn82bC0g
 * 死锁：一组互相竞争资源的线程因互相等待，导致“永久”阻塞的现象
 * 死锁四个条件：
 * 1、互斥
 * 2、占有且等待
 * 3、不可抢占
 * 4、循环等待
 *
 * @author chenpenghui
 * @date 2021-4-19
 */
public class Account {

    private int balance;

    /**
     * 转账
     *
     * @param target
     * @param amt
     */
    void transfer(Account target, int amt) {
        // 锁定转出账本
        synchronized (this) {
            // 锁定转入账本
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }

        }
    }
}
