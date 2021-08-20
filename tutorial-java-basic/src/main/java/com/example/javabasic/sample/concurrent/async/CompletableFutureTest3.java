package com.example.javabasic.sample.concurrent.async;

import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: cph
 * @date: 2021-8-13
 */
public class CompletableFutureTest3 {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> cfQueryMobile = CompletableFuture.supplyAsync(() -> queryCode("移动", "10086.com"));
        CompletableFuture<String> cfQueryTelecom = CompletableFuture.supplyAsync(() -> queryCode("电信", "10000.com"));
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryMobile, cfQueryTelecom);

        CompletableFuture<Double> cfFetchMobile = cfQuery.thenApplyAsync((code) -> fetchPrice((String) code, "10086.cn"));
        CompletableFuture<Double> cfFetchTelecom = cfQuery.thenApplyAsync((code) -> fetchPrice((String) code, "10000.cn"));
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchMobile, cfFetchTelecom);

        cfFetch.thenAccept((result) -> System.out.println("price: " + result));

        Thread.sleep(2000);

    }

    static String queryCode(String name, String url){
        System.out.println("query code from url: " + url + " name: " + name);
        try {
            Thread.sleep((long) Math.random() * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "666";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("fetch price from url: " + url + " code: " + code);
        try {
            Thread.sleep((long) Math.random() * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5 + Math.random() * 20;
    }
}
