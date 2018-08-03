package com.fxb.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
public class Student {
    private int id;
    private String name;
    private Set<Teacher> teachers = new HashSet<Teacher>();
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy="students")
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
