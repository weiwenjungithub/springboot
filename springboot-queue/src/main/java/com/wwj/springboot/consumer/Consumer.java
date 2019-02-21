package com.wwj.springboot.consumer;

import com.wwj.springboot.cache.BlockingQueueMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author weiwenjun
 * @since 2018/11/6
 */
@Component
public class Consumer {

    @Scheduled(fixedDelay = 3000)
    public void consumerMessage() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                String msg = BlockingQueueMessage.queue.poll(2, TimeUnit.SECONDS);
                if (null != msg) {
                    System.out.println("---接收到的消息---：" + msg);
                } else {
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
