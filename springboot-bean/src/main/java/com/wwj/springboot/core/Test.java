package com.wwj.springboot.core;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author weiwenjun
 * @since 2019/2/20
 */
@Component
public class Test {

    @Resource
    private TestBean testBean;
    @Resource
    private Environment environment;

    @PostConstruct
    public void a(){
        System.out.println(testBean.getName());
    }
}
