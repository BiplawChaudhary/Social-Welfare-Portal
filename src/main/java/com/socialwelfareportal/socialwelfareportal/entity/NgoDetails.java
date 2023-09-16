package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "ngo_details")
class NgoDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String panNumber;
    private String swcNumber;
    private String regNumber;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String password;

}
