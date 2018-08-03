package com.fxb.hibernate;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
@Entity
public class Student {
    private int id;
    private String name;
    private Set<Course> courses = new HashSet<Course>();

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name="score",joinColumns =@JoinColumn(name="student_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
