package com.fxb.hibernate.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
@Entity
/*@Table(name = "_Student")*/
public class Student {
    private int id;
    private String name;
    private int age;
    private String girlFriend;
    private Date date;
    private Title title;

@Id
    public int getId() {
        return id;
    }
/*@Column(name = "_name") 自定义字段名*/
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Transient //短暂的 不做持久化存储
    public String getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(String girlFriend) {
        this.girlFriend = girlFriend;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Enumerated(EnumType.STRING)//枚举类型
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
