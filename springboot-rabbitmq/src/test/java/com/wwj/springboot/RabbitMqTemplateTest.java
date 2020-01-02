package com.wwj.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author weiwenjun
 * @since 2019/12/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RabbitMqTemplateTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("wwj-exchange-topic", "wwj-test-queue1", "我的需要同步的消息");
    }
}
