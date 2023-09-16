package com.socialwelfareportal.socialwelfareportal.Entity;

import javax.persistence.*;

@Entity
@Table(name="ngo_details")
public class NgoDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ngoName;

    private String address;

    


}
