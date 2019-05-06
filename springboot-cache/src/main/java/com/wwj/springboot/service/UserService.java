package com.wwj.springboot.service;

import com.wwj.springboot.model.User;

import java.util.List;

/**
 * @author weiwenjun
 * @since 2018/11/1
 */
public interface UserService {

    /**
     * 获取用户
     * @return user
     */
    User findUser();

    /**
     * 更新用户信息
     * @return user
     */
    User updateUser();

    /**
     * 清除缓存的用户信息
     */
    void clearUser();

}
