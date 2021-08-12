package com.example.javabasic.sample.concurrent.async;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: cph
 * @date: 2021-8-12
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureTest::fetchPrice);
        cf.thenAccept((result) -> System.out.println("price: " + result));
        cf.exceptionally( e -> {
            e.printStackTrace();
            return null;
        });
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed");
        }

        return 5 + Math.random() * 20;
    }
}
