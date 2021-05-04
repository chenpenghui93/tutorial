package com.example.redissession.jedis;

import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author chenpenghui
 * @date 2021-5-4
 */
public class JedisPoolTest {
    public static void main(String[] args) {
//        jedisPool();
//        sharedPool();
        sentinelPool();
    }

    /**
     * 哨兵
     */
    private static void sentinelPool() {
        String masterName = "redis-master";
        HashSet<String> sentinels = new HashSet<>();
        sentinels.add("139.180.136.94:26379");
        sentinels.add("45.76.144.196:26379");
        sentinels.add("45.77.240.166:26379");

        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName, sentinels);
        sentinelPool.getResource().set("sentinelPool", "sentinelPool");
        System.out.println(sentinelPool.getResource().get("sentinelPool"));

    }

    /**
     * 分片
     */
    private static void sharedPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisShardInfo shardInfo1 = new JedisShardInfo("139.180.136.94", 6379);
        List<JedisShardInfo> infoList = Arrays.asList(shardInfo1);
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, infoList);
        ShardedJedis jedis = shardedJedisPool.getResource();
        jedis.set("sharedPool", "sharedPool");
        System.out.println(jedis.get("sharedPool"));
    }

    /**
     * 普通连接池
     */
    private static void jedisPool() {
        JedisPool jedisPool = new JedisPool("139.180.136.94", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedisPool", "jedisPool");
        System.out.println(jedis.get("jedisPool"));
    }


}
