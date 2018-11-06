package com.wwj.springboot.bean;

/**
 * @author weiwenjun
 * @since 2018/10/7
 */
public class Ownwer {

    private String name;
    private String tel;

    @Override
    public String toString() {
        return "Ownwer{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Ownwer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
