package com.socialwelfareportal.socialwelfareportal.entity;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
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

    public GrantDetails(GrantRequestDto dto){
        this.fiscalYear = dto.getFiscalYear();
        this.description = dto.getDescription();
        this.name = dto.getName();
        this.noOfIndividual = dto.getNoOfIndividual();
    }

    public GrantDetails() {

    }
}
