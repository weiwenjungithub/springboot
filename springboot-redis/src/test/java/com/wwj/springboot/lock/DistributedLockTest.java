package com.wwj.springboot.lock;

import com.wwj.springboot.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author weiwenjun
 * @since 2018/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class DistributedLockTest {


    @Autowired
    private RedisTemplate redisTemplate;

    public static final String NX = "nx";
    public static final String ID = "id";


    @Test
    public void lock() throws InterruptedException {
        DistributedLock.lock(redisTemplate.getRequiredConnectionFactory().getConnection(), NX, ID, 10L, TimeUnit.SECONDS, 5, 2L, TimeUnit.SECONDS);
    }

    @Test
    public void lockInterruptibly() {
    }

    @Test
    public void tryLock() {
        Boolean aBoolean = DistributedLock.tryLock(redisTemplate.getRequiredConnectionFactory().getConnection(), NX, ID, 10L, TimeUnit.SECONDS);
    }

    @Test
    public void unlock() {
        DistributedLock.unlock(redisTemplate.getRequiredConnectionFactory().getConnection(), NX, ID);
    }

    @Test
    public void Test(){

        new Thread(() -> lockOps("线程一")).start();
        new Thread(() -> lockOps("线程二")).start();
    }

    private void lockOps(String name) {
        String id = UUID.randomUUID().toString();
        try {
            DistributedLock.lock(redisTemplate.getRequiredConnectionFactory().getConnection(), NX, id, 10L, TimeUnit.SECONDS);
            ops(name);
            DistributedLock.unlock(redisTemplate.getRequiredConnectionFactory().getConnection(), NX, id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void ops(String name) {
        System.out.println(name + ":正在操作数据库...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ":操作完成!!!");
    }
}