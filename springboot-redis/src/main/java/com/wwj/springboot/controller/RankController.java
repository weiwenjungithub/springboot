package com.wwj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author weiwenjun
 * @since 2018/9/26
 */
@RestController
@RequestMapping("/")
public class RankController {

    public static final String SCORE_RANK = "score_rank";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/add")
    public String add() {
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三1", 54);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三2", 57);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三3", 21);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三4", 13);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三5", 15);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三6", 5);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三7", 63);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三8", 42);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三9", 38);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三10", 22);
        redisTemplate.opsForZSet().add(SCORE_RANK, "张三11", 1);
        return "新增成功";
    }

    @RequestMapping("/rank")
    public void set() {

        long startRank = 0;
        long endRank = 5;
        Set<String> rangeSet = redisTemplate.opsForZSet().range(SCORE_RANK, startRank, endRank);
        System.out.println("获取排名从 " + startRank + " - " + endRank + " 的排名集合:" + rangeSet);

        long startScore = 10;
        long endScore = 20;
        Set<String> rangeByScoreSet = redisTemplate.opsForZSet().rangeByScore(SCORE_RANK, startScore, endScore);
        System.out.println("获取分数从 " + startScore + " - " + endScore + " 的排名集合:" + rangeByScoreSet);

        String name = "张三9";
        Long rank = redisTemplate.opsForZSet().rank(SCORE_RANK, name);
        System.out.println("获取 " + name + " 的排名:" + rank);

        double minScore = 20;
        double maxScore = 30;
        Long count = redisTemplate.opsForZSet().count(SCORE_RANK, minScore, maxScore);
        System.out.println("获取积分 "+minScore +"-"+ maxScore +" 区间的人数:" + count);

    }

}
