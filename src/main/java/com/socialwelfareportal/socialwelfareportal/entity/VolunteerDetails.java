package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="volunteer_details")
public class VolunteerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @Column(name = "email")
    private String email;
    @ManyToMany(mappedBy = "volunteer")
    private List<Events> eventsList;
}
