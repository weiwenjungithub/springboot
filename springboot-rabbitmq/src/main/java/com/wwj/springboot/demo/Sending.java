package com.wwj.springboot.demo;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 */
@Component
public class Sending {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sending(){
        amqpTemplate.convertAndSend("wwj-exchange-topic", "wwj-test-queue1", "我的第一个消息");
    }

}
