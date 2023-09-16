package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.VolunteerResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;

public interface VolunteerService {
    public void createVolunteer(VolunteerRequestDto volunteerRequestDto);
    public VolunteerResponseDto getVolunteer(VolunteerDetails volunteerDetails);
}
