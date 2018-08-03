package com.fxb.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
public class Teacher {
    private int id;
    private String name;
    private Set<Student> students = new HashSet<Student>();

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @ManyToMany
    @JoinTable(name="teacher_student",
            joinColumns=
            @JoinColumn(name="teacher_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="student_id", referencedColumnName="id")
    )
    public Set<Student> getStudents() {
        return students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
