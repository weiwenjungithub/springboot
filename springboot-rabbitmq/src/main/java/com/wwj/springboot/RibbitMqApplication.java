package com.wwj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author weiwenjun
 * @since 2019/12/2
 */
@EnableScheduling
@SpringBootApplication
public class RibbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbitMqApplication.class);
    }
}
