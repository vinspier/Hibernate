package com.fxb.hibernate;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@Entity(name = "employee")
public class Employee implements Serializable {
    private int id;
    private String name;
    private String em_sex;
    private Set<Role> roles = new HashSet<Role>();

    public Employee() {
    }

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

    public String getEm_sex() {
        return em_sex;
    }

    public void setEm_sex(String em_sex) {
        this.em_sex = em_sex;
    }

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "employees",fetch = FetchType.LAZY)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
