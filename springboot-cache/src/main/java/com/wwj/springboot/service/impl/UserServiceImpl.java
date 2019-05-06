package com.wwj.springboot.service.impl;

import com.wwj.springboot.model.User;
import com.wwj.springboot.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author weiwenjun
 * @since 2018/11/1
 */
@Service
@CacheConfig(cacheNames = "CacheConfigName")
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable(value = {"valueName", "valueName2"}, key = "'keyName1'")
    public User findUser() {
        System.out.println("执行方法...");
        return new User("id1", "张三", "深圳", "1234567", 18);
    }

    @Override
    @CachePut(value = "valueName", key = "'keyName1'")
    public User updateUser() {
        System.out.println("更新用户...");
        return new User("id1", "李四", "北京", "1234567", 18);
    }

    @Override
    @CacheEvict(value = "valueName",allEntries = true)
    public void clearUser() {
        System.out.println("清除缓存...");
    }


}

