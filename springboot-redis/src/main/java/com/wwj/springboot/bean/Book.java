package com.wwj.springboot.bean;

/**
 * @author weiwenjun
 * @since 2018/10/7
 */
public class Book {
    private String name;
    private Double money;
    private Ownwer ownwer;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", ownwer=" + ownwer +
                '}';
    }

    public Ownwer getOwnwer() {
        return ownwer;
    }

    public void setOwnwer(Ownwer ownwer) {
        this.ownwer = ownwer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
