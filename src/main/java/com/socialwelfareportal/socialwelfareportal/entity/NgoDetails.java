package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ngo_details")
public class NgoDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "pan_number")
    private String panNumber;
    @Column(name = "swc_number")
    private String swcNumber;
    @Column(name = "reg_number")
    private String regNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "ngos")
    private List<Events> events;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
