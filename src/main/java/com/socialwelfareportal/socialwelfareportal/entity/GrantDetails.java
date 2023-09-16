package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grant_details")
public class GrantDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fiscalYear;

    private String description;

    private String name;

    private Integer noOfIndividual;

    private Status status;
}
