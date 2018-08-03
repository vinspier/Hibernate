package com.fxb.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
@Entity
@Table(name="t_course")
public class Course {
    private int id;
    private String name;
    private Set<Student> studentSet = new HashSet<Student>();//Set Map List<>

    //当取出的数据需要进行排序的时候 可以使用List
/*    private List<Student> studentList = new ArrayList<Student>();*/

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy="course",cascade={CascadeType.ALL})//默认fetch=FetchType.LAZY
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
