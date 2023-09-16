package com.socialwelfareportal.socialwelfareportal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grant_details")
public class GrantDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date fiscalYear;

    private String description;

    private String fields;

    private Integer noOfIndividual;

    private Status status;
}
