package com.wwj.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author weiwenjun
 * @since 2019/12/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RabbitMqAdminTest {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void ExchangesTest() {
        amqpAdmin.declareExchange(new ExchangeBuilder("wwj-exchange-topic", "topic").build());
    }

    @Test
    public void BindsTest() {
        Binding a = new Binding("wwj-test-queue1", Binding.DestinationType.QUEUE, "wwj-exchange-topic", "wwj-test-queue1", null);
        amqpAdmin.declareBinding(a);
    }

    @Test
    public void ExchangesQueues() {
        Queue queue = new Queue("wwj-test-queue1");
        String s = amqpAdmin.declareQueue(queue);
        System.out.println(s);

    }
}
