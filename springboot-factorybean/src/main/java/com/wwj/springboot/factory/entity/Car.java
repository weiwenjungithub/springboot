package com.wwj.springboot.factory.entity;

/**
 * @author weiwenjun
 * @since 2019/5/27
 */
public class Car {
    private String brand;
    private String maxSpeed;
    private String price;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
