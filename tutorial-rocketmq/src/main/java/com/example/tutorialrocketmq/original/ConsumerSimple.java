package com.example.tutorialrocketmq.original;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author: cph
 * @date: 2021/9/1 20:33
 */
public class ConsumerSimple {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-first-group");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("springboot-topic", "*");
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            System.out.printf("%s receive new message: %s %n ", Thread.currentThread().getId(), list);
            for (MessageExt msg : list) {
                String topic = msg.getTopic();
                String msgBody;
                try {
                    msgBody = new String(msg.getBody(), Charset.defaultCharset());
                } catch (Exception e) {
                    e.printStackTrace();
                    // 消费失败
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                String tags = msg.getTags();
                System.out.println("topic:" + topic + " tags:" + tags + " msgBody:" + msgBody);
            }
            // 消费成功
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        System.out.println("consumer started. %n");

    }
}
