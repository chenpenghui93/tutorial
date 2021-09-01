package com.example.tutorialrocketmq.spring.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author: cph
 * @date: 2021/9/1 19:42
 */
@SpringBootTest
class MessageSenderTest {

    @Autowired
    MessageSender messageSender;

    @Test
    void syncSend() {
        messageSender.syncSend();
    }

    @Test
    void asyncSend() throws Exception {
        messageSender.asyncSend();
    }

    @Test
    void sendOneWay() {
        messageSender.sendOneWay();
    }

    @Test
    void sendOneWayOrderly() {
        messageSender.sendOneWayOrderly();
    }
}