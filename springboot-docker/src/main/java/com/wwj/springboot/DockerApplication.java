package com.wwj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author weiwenjun
 * @since 2018/9/26
 */
@SpringBootApplication
@EnableScheduling
public class DockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class);
    }
}
