package com.wwj.springboot.factory.config;

import com.wwj.springboot.factory.bean.CarFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/5/27
 */
@Component
public class CarBean {

    @Bean("car")
    public CarFactoryBean setCarFactoryBean(){
        CarFactoryBean carFactoryBean = new CarFactoryBean();
        carFactoryBean.setCarInfo("超级跑车,400,2000000");
        return carFactoryBean;
    }
}
