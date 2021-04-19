package com.example.javabasic.sample.middleware.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * redis async
 *
 * @author chenpenghui
 * @date 2020-10-22
 */
public class LettuceASyncTest {
    public static void main(String[] args) {
        RedisClient client = RedisClient.create("redis://127.0.0.1:6379");
        StatefulRedisConnection<String, String> connection = client.connect();
        // 异步执行
        RedisAsyncCommands<String, String> async = connection.async();
        async.set("async", "async:1022");
        RedisFuture<String> future = async.get("async");
        try {
            String value = future.get(60, TimeUnit.SECONDS);
            System.out.println("===" + value + "===");
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
