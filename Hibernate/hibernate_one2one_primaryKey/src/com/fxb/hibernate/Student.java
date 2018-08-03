package com.fxb.hibernate;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class Student {
    private int id;
    private String name;
    private String sex;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
