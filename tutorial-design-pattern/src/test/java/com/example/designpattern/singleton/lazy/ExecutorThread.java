package com.example.designpattern.singleton.lazy;

import com.example.designpattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @author cph
 * @date 2019/4/6
 */
public class ExecutorThread implements Runnable {
    @Override
    public void run() {
//        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
//        LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();
//        LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstance();
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ": " + ThreadLocalSingleton.getInstance());
//        System.out.println(Thread.currentThread().getName() + ": " + ThreadLocalSingleton.getInstance());
//        System.out.println(Thread.currentThread().getName() + ": " + ThreadLocalSingleton.getInstance());

        System.out.println(Thread.currentThread().getName() + ": " + singleton);
    }
}
