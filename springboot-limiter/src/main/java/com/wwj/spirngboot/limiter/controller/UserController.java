package com.wwj.spirngboot.limiter.controller;

import com.wwj.spirngboot.limiter.annotation.ServiceLimiter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weiwenjun
 * @since 2019/5/6
 */
@Controller
@RequestMapping("/users")
public class UserController {


    @RequestMapping("/getUserName")
    @ResponseBody
    @ServiceLimiter
    public String getUserName() {
        return "success";
    }
}
