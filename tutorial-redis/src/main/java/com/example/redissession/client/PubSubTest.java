package com.example.redissession.client;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.RedisPubSubListener;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.sync.RedisPubSubCommands;

/**
 * @author chenpenghui
 * @date 2020-10-22
 */
public class PubSubTest {
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://127.0.0.1:6379");
        RedisPubSubListener<String, String> listener = new RedisPubSubListener<String, String>() {
            @Override
            public void message(String pattern, String channel) {
                System.out.println("message:" + pattern + "," + channel);
            }

            @Override
            public void message(String pattern, String channel, String message) {
                System.out.println("message:" + pattern + "," + channel + "," + message);
            }

            @Override
            public void psubscribed(String pattern, long count) {
                System.out.println("psub:" + pattern + "," + count);
            }

            @Override
            public void punsubscribed(String pattern, long count) {
                System.out.println("punsub:" + pattern + "," + count);
            }

            @Override
            public void subscribed(String channel, long count) {
                System.out.println("sub:" + channel + "," + count);
            }

            @Override
            public void unsubscribed(String channel, long count) {
                System.out.println("ubsub:" + channel + "," + count);
            }
        };
        StatefulRedisPubSubConnection<String, String> pubSubConnection = redisClient.connectPubSub();
        pubSubConnection.addListener(listener);
        RedisPubSubCommands<String, String> connection = pubSubConnection.sync();
        connection.subscribe("pubsub");

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pubSubConnection.close();
        redisClient.shutdown();
    }

}
