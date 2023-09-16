package com.socialwelfareportal.socialwelfareportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grant_details")
@Getter
@Setter
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
