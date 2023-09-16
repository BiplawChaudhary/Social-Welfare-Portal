package com.socialwelfareportal.socialwelfareportal.dto.responsedto;

import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerResponseDto {
    private String name;
    private String address;
    private String contact;
    private String email;
    private List<Integer> event_id;
}
