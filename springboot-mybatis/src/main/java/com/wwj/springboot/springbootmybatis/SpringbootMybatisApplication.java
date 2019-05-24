package com.wwj.springboot.springbootmybatis;

import com.wwj.springboot.springbootmybatis.entity.User;
import com.wwj.springboot.springbootmybatis.mapper.CityMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author weiwenjun
 */
@SpringBootApplication
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

   /*   @Resource
    private CityMapper cityMapper;

    @PostConstruct
    public void test(){
        User byState = cityMapper.findByState("");
        System.out.println(byState.getName());
    }*/
}
