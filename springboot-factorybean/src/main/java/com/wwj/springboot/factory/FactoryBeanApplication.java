package com.wwj.springboot.factory;


import com.wwj.springboot.factory.bean.CarFactoryBean;
import com.wwj.springboot.factory.config.CarBean;
import com.wwj.springboot.factory.config.Content;
import com.wwj.springboot.factory.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * @author weiwenjun
 * @since 2019/2/2
 */
@EnableScheduling
@SpringBootApplication
public class FactoryBeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryBeanApplication.class, args);
    }

    @Scheduled(fixedDelay = 3000)
    public void test() {
        //获得的是CarFactoryBean
        CarFactoryBean carFactoryBean = (CarFactoryBean) Content.getBean("&car");
        //获得Car对象
        Car car = (Car) Content.getBean("car");
        System.out.println(carFactoryBean);
        System.out.println(car);
    }
}
