package com.fxb.hibernate;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class StudentIdCard {
    private int id;
    private String number;
    private Student student;

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
