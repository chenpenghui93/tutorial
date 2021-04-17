package com.example.designpattern.delegate.simple;

/**
 * 委派模式负责任务的调度和分配，可看作一种特殊情况下的静态全权代理
 * 代理模式重过程，委派模式重结果
 *
 * @author cph
 * @date 2019/7/18
 */
public class DelegateTest {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Leader leader = new Leader();
        boss.command("测试", leader);
        boss.command("编码", leader);
    }
}
