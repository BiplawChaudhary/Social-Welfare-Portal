package com.socialwelfareportal.socialwelfareportal.service.impl;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;
import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;
import com.socialwelfareportal.socialwelfareportal.repo.VolunteerRepo;
import com.socialwelfareportal.socialwelfareportal.service.EventService;
import com.socialwelfareportal.socialwelfareportal.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {
    VolunteerRepo volunteerRepo;

    @Autowired
    EventService eventService;
    @Override
    public void createVolunteer(VolunteerRequestDto volunteerRequestDto) {
            VolunteerDetails volunteerDetails = new VolunteerDetails();
            volunteerDetails.setName(volunteerRequestDto.getName());
            volunteerDetails.setAddress(volunteerRequestDto.getAddress());
            volunteerDetails.setContact(volunteerRequestDto.getContact());
            volunteerDetails.setEmail(volunteerRequestDto.getEmail());
            Events events = eventService.getEventById(volunteerRequestDto.getEvent_id());
            List<Events> eventsList = new ArrayList<>();
            eventsList.add(events);
            List<VolunteerDetails> volunteerDetailsList = new ArrayList<>();
            volunteerDetailsList.add(volunteerDetails);
            events.setVolunteer(volunteerDetailsList);
            volunteerDetails.setEventsList(eventsList);
            volunteerRepo.save(volunteerDetails);
    }
}
