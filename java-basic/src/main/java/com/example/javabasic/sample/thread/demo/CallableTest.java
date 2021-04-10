package com.example.javabasic.sample.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用ExecutorService、Callable、Future实现有返回结果的多线程
 *
 * @author chenpenghui
 * @date 2021-3-10
 */
public class CallableTest {
    public static void main(String[] args) throws Exception {

        // TODO: 2021-3-10 使用ThreadPoolExecutor替换Exectors
        // 创建线程池
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        // 创建有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            MyCallable callable = new MyCallable(i);
            // 执行任务并获取Future对象
            Future<Object> future = pool.submit(callable);
            list.add(future);
        }
        // 关闭线程池
        pool.shutdown();

        for (Future f : list) {
            System.out.println("---" + f.get().toString());
        }

    }

    static class MyCallable implements Callable<Object> {

        private Integer taskNum;

        public MyCallable(Integer taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动...");
            long start = System.currentTimeMillis();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            System.out.println(">>>" + taskNum + "任务终止...");
            return "任务" + taskNum + "返回结果，耗时" + (end - start) + "ms";
        }
    }
}
