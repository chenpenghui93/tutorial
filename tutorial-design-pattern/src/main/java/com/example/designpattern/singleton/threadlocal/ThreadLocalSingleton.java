package com.example.designpattern.singleton.threadlocal;

/**
 * @author cph
 * @date 2019/4/29
 */

//伪线程安全：线程内部是线程安全的，线程之外是不安全的
public class ThreadLocalSingleton {

    private static ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            ThreadLocal.withInitial(ThreadLocalSingleton::new);

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
