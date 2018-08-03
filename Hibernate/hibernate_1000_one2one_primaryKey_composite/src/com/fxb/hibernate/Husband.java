package com.fxb.hibernate;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
@Entity
public class Husband {
    private int id;
    private String name;
    private Wife wife;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToOne
    @JoinColumns(
            {
                    @JoinColumn(name="wifeId",referencedColumnName="id"),
                    @JoinColumn(name="wifeName",referencedColumnName = "name")
            }
    )
    public Wife getWife() {
        return wife;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
