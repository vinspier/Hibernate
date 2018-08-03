package com.fxb.hibernate;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
@Entity
@IdClass(WifePk.class)
public class Wife {
    private int id;
    private String name;
    private String sex;

    @Id
    public int getId() {
        return id;
    }

    @Id
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
