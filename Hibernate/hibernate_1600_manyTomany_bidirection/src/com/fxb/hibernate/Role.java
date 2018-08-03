package com.fxb.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
@Entity(name = "role")
public class Role implements Serializable {
    private int id;
    private String role_name;
    private Set<Employee> employees = new HashSet<Employee>();

    public Role() {
    }


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @ManyToMany
    @JoinTable(name = "role_employee",
            joinColumns =
                    @JoinColumn(name = "role_id",referencedColumnName = "id"),
            inverseJoinColumns =
                    @JoinColumn(name = "em_id",referencedColumnName = "id")
    )
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
