package com.fxb.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
@Entity
public class Wife {
    private int id;
    private String name;
    private Husband husband;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToOne(mappedBy="wife")
    public Husband getHusband() {
        return husband;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
