package com.wwj.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.wwj.springboot.controller.RankController.SCORE_RANK;
import static org.junit.Assert.*;

/**
 * @author weiwenjun
 * @since 2018/9/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RankControllerTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 单个新增
     */
    @Test
    public void add() {
        redisTemplate.opsForZSet().add(SCORE_RANK, "李四", 8899);
    }

    /**
     * 批量新增
     */
    @Test
    public void batchAdd() {
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            DefaultTypedTuple<String> tuple = new DefaultTypedTuple<>("张三" + i, 1D + i);
            tuples.add(tuple);
        }
        System.out.println("循环时间:" +( System.currentTimeMillis() - start));
        Long num = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
        System.out.println("批量新增时间:" +(System.currentTimeMillis() - start));
        System.out.println("受影响行数：" + num);
    }

    /**
     * 移除
     */
    @Test
    public void remove() {
        Long aLong = redisTemplate.opsForZSet().zCard(SCORE_RANK);
        System.out.println(aLong);
//        redisTemplate.opsForZSet().removeRange(SCORE_RANK,0,10000000);
//        Long num = redisTemplate.opsForZSet().remove(SCORE_RANK, "张三");
//        System.out.println("受影响行数：" + num);
    }

    /**
     * 获取排行列表
     */
    @Test
    public void list() {
        Set<String> range = redisTemplate.opsForZSet().reverseRange(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行列表:" + JSON.toJSONString(range));
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores = redisTemplate.opsForZSet().reverseRangeWithScores(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行和分数列表:" + JSON.toJSONString(rangeWithScores));
    }

    /**
     * 获取单个的排行
     */
    @Test
    public void find(){
        Long rankNum = redisTemplate.opsForZSet().reverseRank(SCORE_RANK, "李四");
        System.out.println("李四的个人排名：" + rankNum);

        Double score = redisTemplate.opsForZSet().score(SCORE_RANK, "李四");
        System.out.println("李四的分数:" + score);
    }

    /**
     * 统计两个分数之间的人数
     */
    @Test
    public void count(){
        Long count = redisTemplate.opsForZSet().count(SCORE_RANK, 8001, 9000);
        System.out.println("统计8001-9000之间的人数:" + count);
    }

    /**
     * 获取整个集合的基数(数量)
     */
    @Test
    public void zCard(){
        Long aLong = redisTemplate.opsForZSet().zCard(SCORE_RANK);
        System.out.println("集合的基数为：" + aLong);
    }

    /**
     * 使用加法操作分数
     */
    @Test
    public void incrementScore(){
        Double score = redisTemplate.opsForZSet().incrementScore(SCORE_RANK, "李四a", 1000);
        System.out.println("李四分数+1000后：" + score);
    }

}