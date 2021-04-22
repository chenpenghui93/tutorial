package com.example.redissession.client;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

/**
 * redis sync
 *
 * @author chenpenghui
 * @date 2020-10-22
 */
public class LettuceSyncTest {
    public static void main(String[] args) {
        // 创建客户端 redis://password@ip:port
        RedisClient client = RedisClient.create("redis://127.0.0.1:6379");
        // 线程安全的长连接，连接丢失时会自动重连
        StatefulRedisConnection<String, String> connection = client.connect();
        // 获取同步执行命令，默认超时时间60s
        RedisCommands<String, String> sync = connection.sync();

        sync.set("my_key", "my_value");
        String value = sync.get("my_key");
        System.out.println("###" + value + "###");

        // 关闭连接
        connection.close();
        // 关闭客户端
        client.shutdown();
    }
}
