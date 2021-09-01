package com.example.tutorialrocketmq.spring.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: cph
 * @date: 2021/9/1 17:45
 */
@Component
public class MessageSender {

    @Autowired
    RocketMQTemplate rocketMQTemplate;

    public void syncSend(){
        SendResult result = rocketMQTemplate.syncSend("springboot-topic:tag", "这是同步消息", 2000);
        System.out.println(result);
    }

    public void asyncSend() throws Exception {
        rocketMQTemplate.asyncSend("springboot-topic:tag", "这是异步消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("回调消息: " + sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("异常消息: " + e.getMessage());
            }
        });
        TimeUnit.SECONDS.sleep(10);
    }

    public void sendOneWay(){
        rocketMQTemplate.sendOneWay("springboot-topic:tag", "这是一条单向消息");
    }

    public void sendOneWayOrderly(){
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.sendOneWayOrderly("springboot-topic:tag", "这是一条顺序消息"+i,"1837");
        }
    }

}
