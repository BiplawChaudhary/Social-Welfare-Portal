package com.socialwelfareportal.socialwelfareportal.entity;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "grantDetails", cascade = CascadeType.ALL)
    private List<UploadDetails> uploadDetails;

    public GrantDetails() {

    }

    public GrantDetails(GrantRequestDto dto){
        this.fiscalYear = dto.getFiscalYear();
        this.description = dto.getDescription();
        this.name = dto.getName();
        this.noOfIndividual = dto.getNoOfIndividual();
        this.status = Status.pending;
    }


}
