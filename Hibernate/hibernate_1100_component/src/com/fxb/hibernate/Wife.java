package com.fxb.hibernate;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class Wife {
    private String wifeName;
    private int age;

    public String getWifeName() {
        return wifeName;
    }

    public int getAge() {
        return age;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
