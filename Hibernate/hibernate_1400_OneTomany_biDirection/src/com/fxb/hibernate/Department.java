package com.fxb.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
@Entity(name = "department")
public class Department implements Serializable {
    private int dep_id;
    private String dep_name;
    private String dep_description;
    private Set<Employee> employees = new HashSet<Employee>();
    public Department() {
    }

    @Id
    @GeneratedValue
    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_description() {
        return dep_description;
    }

    public void setDep_description(String dep_description) {
        this.dep_description = dep_description;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
