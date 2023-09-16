package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "role_name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
