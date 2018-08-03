package com.fxb.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

@Entity
public class Organization {
    private int id;
    private String name;
    private Set<Organization> children = new HashSet<Organization>();
    private Organization parent;

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

    @OneToMany(cascade=CascadeType.ALL,mappedBy="parent",fetch=FetchType.LAZY)
    public Set<Organization> getChildren() {
        return children;
    }

    public void setChildren(Set<Organization> children) {
        this.children = children;
    }

    @ManyToOne
    @JoinColumn(name="p_id")
    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization parent) {
        this.parent = parent;
    }
}
