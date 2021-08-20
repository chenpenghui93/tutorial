package com.example.javabasic.sample.concurrent.async;

import java.util.concurrent.CompletableFuture;

/**
 * @description: 异步串行调用
 * @author: cph
 * @date: 2021-8-13
 */
public class CompletableFutureTest2 {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> queryCode("移动"));

        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> fetchPrice(code));

        cfFetch.thenAccept((result) -> System.out.println("price: " + result));

        Thread.sleep(2000);

    }

    static String queryCode(String name) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "999";
    }

    static Double fetchPrice(String code){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 5 + Math.random() * 20;
    }
}
