package com.example.tutorialrocketmq.spring.consumer;

import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author: cph
 * @date: 2021/9/1 16:37
 */
@Component
@RocketMQMessageListener(topic = "springboot-topic", consumerGroup = "my-first-group",
        messageModel = MessageModel.CLUSTERING, consumeMode = ConsumeMode.CONCURRENTLY)
public class MessageConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        try {
            System.out.println("消息来了: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
