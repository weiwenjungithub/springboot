package com.wwj.springboot.service.impl;

import com.wwj.springboot.model.User;
import com.wwj.springboot.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiwenjun
 * @since 2018/11/1
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable(value="list",key="userList")
    public List<User> list() {
        System.out.println("不从缓存获取.");
        List<User> list = new ArrayList<>();
        User user = new User("张三","深圳","1234567",18);
        list.add(user);
        return list;
    }
}
