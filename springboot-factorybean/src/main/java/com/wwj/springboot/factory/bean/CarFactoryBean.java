package com.wwj.springboot.factory.bean;

import com.wwj.springboot.factory.entity.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author weiwenjun
 * @since 2019/5/27
 */
@Component
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(infos[0]);
        car.setPrice(infos[0]);
        return car;
    }

    @Override
    public String toString() {
        return "CarFactoryBean{" +
                "carInfo='" + carInfo + '\'' +
                '}';
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
