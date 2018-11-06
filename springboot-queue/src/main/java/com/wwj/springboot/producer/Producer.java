package com.wwj.springboot.producer;

import com.wwj.springboot.cache.BlockingQueueMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weiwenjun
 * @since 2018/11/6
 */
@Component
public class Producer {

    private static AtomicInteger count = new AtomicInteger();

    @Scheduled(fixedDelay = 1000)
    public void producerMessage1() {
        offer("张三");
    }

    @Scheduled(fixedDelay = 1000)
    public void producerMessage2() {
        offer("李四");
    }

    @Scheduled(fixedDelay = 1000)
    public void producerMessage3() {
        offer("王五");
    }

    private void offer(String name){
        try {
            String str = String.valueOf(count.incrementAndGet());
            System.out.println(name + "生产消息：" + str);
            BlockingQueueMessage.queue.offer(str, 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
