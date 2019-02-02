package com.wwj.springboot.lock;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.types.Expiration;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * @author weiwenjun
 * @since 2018/11/27
 */
public class DistributedLock {


    /**
     * 使用锁
     *
     * @param connection redis连接
     * @param lockKey    锁的key
     * @param requestId  使用锁的对象，只有这个对象可以进行解锁
     * @param expireTime 过期时间
     * @param timeUnit   过期时间单位
     */
    public static void lock(RedisConnection connection, String lockKey, String requestId, Long expireTime, TimeUnit timeUnit) throws InterruptedException {
        lock(connection, lockKey, requestId, expireTime, timeUnit, 0, 0L, TimeUnit.SECONDS);
        //SetOption.SET_IF_ABSENT 如果存在则不插入
    }

    /**
     * 使用锁
     *
     * @param connection redis连接
     * @param lockKey    锁的key
     * @param requestId  使用锁的对象，只有这个对象可以进行解锁
     * @param expireTime 过期时间
     * @param timeUnit   过期时间单位
     */
    public static void lock(RedisConnection connection, String lockKey, String requestId, Long expireTime, TimeUnit timeUnit, int reTryNum, long intervalTime, TimeUnit intervalTimeUnit) throws InterruptedException {

        int num = 0;
        while (reTryNum == 0 || num < reTryNum) {
            if (tryLock(connection, lockKey, requestId, expireTime, timeUnit)) {
                return;
            }else{
                System.out.println("等待锁...");
            }
            if (reTryNum != 0) {
                Thread.sleep(intervalTimeUnit.toMillis(intervalTime));
            }
            num++;
        }
        //SetOption.SET_IF_ABSENT 如果存在则不插入
    }

    /**
     * 尝试锁
     *
     * @param connection redis连接
     * @param lockKey    锁的key
     * @param requestId  使用锁的对象，只有这个对象可以进行解锁
     * @param expireTime 过期时间
     * @param timeUnit   过期时间单位
     * @return 返回锁状态，成功或失败
     */
    public static Boolean tryLock(RedisConnection connection, String lockKey, String requestId, Long expireTime, TimeUnit timeUnit) {
        return connection.set(lockKey.getBytes(), requestId.getBytes(), Expiration.from(expireTime, timeUnit), SetOption.SET_IF_ABSENT);
    }

    /**
     * @param connection redis连接
     * @param lockKey    锁的key
     * @param requestId  使用锁的对象，只有这个对象可以进行解锁
     */
    public static void unlock(RedisConnection connection, String lockKey, String requestId) {
        String script =
                "if " +
                        "   redis.call('get',KEYS[1]) == ARGV[1] " +
                        "then " +
                        "   return redis.call('del',KEYS[1]) " +
                        "else " +
                        "   return 0 end";
        connection.eval(script.getBytes(), ReturnType.INTEGER, 2, lockKey.getBytes(), requestId.getBytes());
    }

    public Condition newCondition() {
        return null;
    }
}
