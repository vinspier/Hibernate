package com.fxb.hibernate;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
@Table(name="t_course")
public class Course {
    private int id;
    private String name;
    private Set<Student> studentSet;

    @Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany
    @JoinColumn(name="courseId")
    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
