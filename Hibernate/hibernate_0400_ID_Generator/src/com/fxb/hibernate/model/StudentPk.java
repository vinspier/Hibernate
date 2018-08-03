package com.fxb.hibernate.model;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
/* 与 @Id连用  @Embeddable*/
public class StudentPk implements Serializable {
    private int id;
    private String name;

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
