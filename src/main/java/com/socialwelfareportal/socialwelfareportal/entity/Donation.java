package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date date;

    private String donor;

    private String phone;

    private String email;

    private Integer quantiy;

    private String description;

    private String type;

}
