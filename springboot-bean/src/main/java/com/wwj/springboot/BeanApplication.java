package com.wwj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author weiwenjun
 * @since 2019/2/2
 */
@SpringBootApplication
public class BeanApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("test.xml");
//        SpringApplication.run(BeanApplication.class);
    }
}