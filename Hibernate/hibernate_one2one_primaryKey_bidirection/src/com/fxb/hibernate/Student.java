package com.fxb.hibernate;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class Student {
    private int id;
    private String name;
    private String sex;
    private StudentIdCard studentIdCard;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public StudentIdCard getStudentIdCard() {
        return studentIdCard;
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

    public void setStudentIdCard(StudentIdCard studentIdCard) {
        this.studentIdCard = studentIdCard;
    }
}
