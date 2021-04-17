package com.example.javabasic.sample.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Lettuce连接池
 *
 * @author chenpenghui
 * @date 2020-10-22
 */
public class LettucePoolTest {
    public static void main(String[] args) {
        RedisClient client = RedisClient.create("redis://localhost:6379");
        GenericObjectPool<StatefulRedisConnection<String, String>> pool = ConnectionPoolSupport.createGenericObjectPool(()
                -> client.connect(), new GenericObjectPoolConfig());
        try (StatefulRedisConnection<String, String> connection = pool.borrowObject()) {
            RedisCommands<String, String> sync = connection.sync();
            sync.set("pool", "pool:1022");
            System.out.println("###" + sync.get("pool"));
            sync.zadd("clazz", 100, "Java");
            sync.zadd("clazz", 200, "Python");
            System.out.println("###" + sync.zcard("clazz"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        pool.close();
        client.shutdown();
    }
}
