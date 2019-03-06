package com.wwj.springboot.core;

/**
 * @author weiwenjun
 * @since 2019/2/20
 */
public class TestBean {

    private String name = "initName";

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
