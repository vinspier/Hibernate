package com.fxb.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
@Table(name="t_course")
public class Course {
    private int id;
    private String name;

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
