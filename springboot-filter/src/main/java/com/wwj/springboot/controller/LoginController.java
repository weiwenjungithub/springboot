package com.wwj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weiwenjun
 * @since 2019/2/2
 * 登录，访问时无需登录即可访问
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("name") String name) {
        return "登录成功," + name + ", 欢迎您!";
    }

    @RequestMapping("/clearSession")
    public String clearSession(HttpServletRequest request){
        request.getSession().invalidate();
        return "clear session success";
    }
}
