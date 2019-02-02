package com.wwj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author weiwenjun
 * @since 2019/2/2
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam("name")String name){
        Random random = new Random();
        return name +  " age is " +random.nextInt(100);
    }
}
