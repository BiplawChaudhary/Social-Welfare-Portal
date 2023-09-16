package com.socialwelfareportal.socialwelfareportal.dto.requestdto;

import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerRequestDto {
    private String name;
    private String address;
    private String contact;
    private String email;
    private Integer event_id;
}
