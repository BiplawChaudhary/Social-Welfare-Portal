package com.socialwelfareportal.socialwelfareportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="upload_details")
@Getter
@Setter
public class UploadDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String path;

    private Integer size;

    private String fileType;

    @ManyToOne
    @JoinColumn(name = "grant_details_id")
    private GrantDetails grantDetails;

    @ManyToOne
    @JoinColumn(name = "ngo_details_id")
    private NgoDetails ngoDetails;

    @ManyToOne
    @JoinColumn(name = "events_id")
    private Events events;

}
