package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Date datename;

    private String eventLocation;

    private String description;

}
