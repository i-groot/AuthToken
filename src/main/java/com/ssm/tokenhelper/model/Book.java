package com.ssm.tokenhelper.model;

/**
 * @Author: zhangxing
 * @Date: 2019/4/21 23:30
 */
public class Book {

    private String id;

    private String name;

    private int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
