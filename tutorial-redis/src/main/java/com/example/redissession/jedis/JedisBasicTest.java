package com.example.redissession.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author chenpenghui
 * @date 2021-5-4
 */
public class JedisBasicTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("139.180.136.94", 6379);
        jedis.set("jedis", "hi jedis");
        System.out.println(jedis.get("jedis"));
        jedis.close();
    }
}
