package com.example.javabasic.sample.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cph
 * @version 1.0
 * @date 2019/1/6
 */
public class UserThreadPool {

    public static void main(String[] args) {
        //
        BlockingQueue queue = new LinkedBlockingDeque(2);

        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");

        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }

    }
}
