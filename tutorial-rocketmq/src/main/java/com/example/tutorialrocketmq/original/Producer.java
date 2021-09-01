package com.example.tutorialrocketmq.original;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author: cph
 * @date: 2021/9/1 20:32
 */
public class Producer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("my-first-group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 5; i++) {
            try {
                // topic 主题
                // tags 标签
                // keys 索引键，多用空格隔开
                // body 消息体
                Message msg = new Message(
                        "springboot-topic",
                        "tagA",
                        "2102",
                        ("RocketMQ " + String.format("%05d", i)).getBytes());
                SendResult sendResult = producer.send(msg);
                System.out.println(String.format("%05d", i) + " : " + sendResult);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        producer.shutdown();
    }
}
