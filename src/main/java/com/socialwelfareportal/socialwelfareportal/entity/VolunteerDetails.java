package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;

@Entity
@Table(name="volunteer_details")
public class VolunteerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;
    private String contact;
    private String email;
}
