package com.example.javabasic.sample.middleware.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.reactive.RedisReactiveCommands;

/**
 * @author chenpenghui
 * @date 2020-10-28
 */
public class ReactiveAPI {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://127.0.0.1:6379");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisReactiveCommands<String, String> reactive = connection.reactive();
        reactive.get("gupao:sync").subscribe(System.out::println);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connection.close();
        redisClient.shutdown();
    }
}
