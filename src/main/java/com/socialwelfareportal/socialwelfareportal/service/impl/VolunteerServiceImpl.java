package com.socialwelfareportal.socialwelfareportal.service.impl;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.VolunteerResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;
import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;
import com.socialwelfareportal.socialwelfareportal.repo.EventsRepo;
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
    private final VolunteerRepo volunteerRepo;



   private final EventService eventService;
    @Override
    public void createVolunteer(VolunteerRequestDto volunteerRequestDto) {
            VolunteerDetails volunteerDetails = new VolunteerDetails();
            volunteerDetails.setName(volunteerRequestDto.getName());
            volunteerDetails.setAddress(volunteerRequestDto.getAddress());
            volunteerDetails.setContact(volunteerRequestDto.getContact());
            volunteerDetails.setEmail(volunteerRequestDto.getEmail());
            Integer id = volunteerRequestDto.getEvent_id();
            System.out.println(id);


            Events events = eventService.getEvent(id).get();

            List<Events> eventsList = new ArrayList<>();
            eventsList.add(events);
            List<VolunteerDetails> volunteerDetailsList = new ArrayList<>();
            volunteerDetailsList.add(volunteerDetails);
            events.setVolunteer(volunteerDetailsList);
            volunteerDetails.setEventsList(eventsList);
            volunteerRepo.save(volunteerDetails);
    }

    @Override
    public VolunteerResponseDto getVolunteer(VolunteerDetails volunteerDetails) {
        VolunteerResponseDto volunteerResponseDto = new VolunteerResponseDto();
        volunteerResponseDto.setName(volunteerDetails.getName());
        volunteerResponseDto.setAddress(volunteerDetails.getAddress());
        volunteerResponseDto.setContact(volunteerDetails.getContact());
        volunteerResponseDto.setEmail(volunteerDetails.getEmail());
        List<Events> eventsList = volunteerDetails.getEventsList();
        List<Integer> event_id = new ArrayList<>();
        for (Events event:eventsList) {
            Integer id = event.getId();
            event_id.add(id);
        }
        return volunteerResponseDto;
    }
}
