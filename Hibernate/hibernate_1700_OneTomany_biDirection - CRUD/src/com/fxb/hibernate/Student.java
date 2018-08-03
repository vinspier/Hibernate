package com.fxb.hibernate;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
@Table(name="t_student")
public class Student {
    private int id;
    private String name;
    private Course course;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade={CascadeType.ALL})//多对一 默认fetchType = eager
    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
