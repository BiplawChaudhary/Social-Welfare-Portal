package com.socialwelfareportal.socialwelfareportal.entity;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public VolunteerDetails(VolunteerRequestDto volunteerRequestDto){
        this.name=volunteerRequestDto.getName();
        this.address=volunteerRequestDto.getAddress();
        this.contact=volunteerRequestDto.getContact();
        this.email=volunteerRequestDto.getEmail();
    }
}
