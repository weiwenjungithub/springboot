package com.wwj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA
 *
 * @author weiwenjun
 * @date 2018/9/12
 */
@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("");
        SpringApplication.run(AopApplication.class);
    }
}
