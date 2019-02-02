package com.wwj.springboot.controller;

import com.wwj.springboot.model.User;
import com.wwj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author weiwenjun
 * @since 2018/11/1
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<User> list(){
        return userService.list();
    }
}
