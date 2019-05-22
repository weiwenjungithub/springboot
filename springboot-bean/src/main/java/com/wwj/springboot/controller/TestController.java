package com.wwj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author weiwenjun
 * @since 2019/5/21
 */
@RequestMapping
public class TestController {

    @RequestMapping
    public String test() {
        return "success";
    }
}
