package com.fxb.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
@Entity(name = "employee")
public class Employee implements Serializable {

    private int em_id;
    private String em_name;
    private String em_sex;
    private Department department;

    public Employee() {
    }

    @Id
    @GeneratedValue()
    public int getEm_id() {
        return em_id;
    }

    public void setEm_id(int em_id) {
        this.em_id = em_id;
    }

    public String getEm_name() {
        return em_name;
    }

    public void setEm_name(String em_name) {
        this.em_name = em_name;
    }

    public String getEm_sex() {
        return em_sex;
    }

    public void setEm_sex(String em_sex) {
        this.em_sex = em_sex;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /*@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    public Set<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }


    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    public Set<MessageBoard> getMessageBoars() {
        return messageBoars;
    }

    public void setMessageBoars(Set<MessageBoard> messageBoars) {
        this.messageBoars = messageBoars;
    }


    @ManyToMany(mappedBy = "employees",cascade = CascadeType.ALL)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }*/
}
