package com.wwj.springboot.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/12/30
 */
//@Component
public class Receiving {

    @RabbitListener(queues = "wwj-test-queue1")
    public void processMessage(String content) {
        System.out.println("receiving content:" + content);
    }
}
