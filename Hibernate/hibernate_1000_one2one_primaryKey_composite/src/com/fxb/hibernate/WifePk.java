package com.fxb.hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class WifePk implements Serializable {
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
