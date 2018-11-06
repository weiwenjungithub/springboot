package com.wwj.springboot.cache;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author weiwenjun
 * @since 2018/11/6
 */
public class BlockingQueueMessage {
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
}
