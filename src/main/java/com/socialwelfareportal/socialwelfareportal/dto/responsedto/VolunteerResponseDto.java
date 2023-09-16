package com.socialwelfareportal.socialwelfareportal.dto.responsedto;

import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerResponseDto {
    private String name;
    private String address;
    private String contact;
    private String email;
    private Integer event_id;

    public VolunteerResponseDto(VolunteerDetails dto){
        this.event_id=this.getEvent_id();
        this.name=dto.getName();
        this.address=dto.getAddress();
        this.contact=dto.getContact();
        this.email=dto.getEmail();
    }
}
