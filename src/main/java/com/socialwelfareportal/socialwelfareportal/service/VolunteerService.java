package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;

public interface VolunteerService {
    public void createVolunteer(VolunteerRequestDto volunteerRequestDto);
}
