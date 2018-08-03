package com.fxb.hibernate.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
@Entity
@IdClass(value=StudentPk.class)
public class Student {
        private int id;
        private String name;
/*        private StudentPk studentPk;*/
        private int age;
        private Scores score;

    @Id
/*    @GeneratedValue(strategy=GenerationType.IDENTITY) 自动生成Id*/
    public int getId() {
        return id;
    }

    @Id
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

/* 与@embeddable连用   @Id */

/*    @EmbeddedId
    public StudentPk getStudentPk() {
        return studentPk;
    }*/

    public int getAge() {
        return age;
    }

    @Enumerated(EnumType.STRING)
    public Scores getScore() {
        return score;
    }



    public void setAge(int age) {
        this.age = age;
    }

/*    public void setStudentPk(StudentPk studentPk) {
        this.studentPk = studentPk;
    }*/

    public void setScore(Scores score) {
        this.score = score;
    }
}

