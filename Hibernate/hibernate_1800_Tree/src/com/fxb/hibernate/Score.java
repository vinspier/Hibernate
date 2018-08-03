package com.fxb.hibernate;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
@Entity
@Table(name="score")
public class Score {
    private int id;
    private int grade;
    private Student student;
    private Course course;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @OneToMany
    @JoinColumn(name="student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name="course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
