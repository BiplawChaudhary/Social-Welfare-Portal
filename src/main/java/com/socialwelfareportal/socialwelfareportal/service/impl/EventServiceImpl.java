package com.socialwelfareportal.socialwelfareportal.service.impl;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.EventRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.EventResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;
import com.socialwelfareportal.socialwelfareportal.repo.EventsRepo;
import com.socialwelfareportal.socialwelfareportal.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventsRepo eventsRepo;

    @Override
    public Events getEventById(Integer id) {
        return eventsRepo.getReferenceById(id);
    }

    @Override
    public void createEvent(EventRequestDto eventRequestDto) throws ParseException {
        Events events = new Events();
        events.setName(eventRequestDto.getName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        events.setDatename(dateFormat.parse(eventRequestDto.getDate()));
        events.setEventLocation(eventRequestDto.getEventLocation());
        events.setDescription(eventRequestDto.getDescription());
        events.setVolunteer(eventRequestDto.getVolunteers());
        eventsRepo.save(events);
    }

    @Override
    public List<EventResponseDto> getAllEvents() {
        List<EventResponseDto> returnList = new ArrayList<>();
        List<Events> eventsList = eventsRepo.findAll();
        for (Events event:eventsList) {
            EventResponseDto eventResponseDto = new EventResponseDto(event);
            returnList.add(eventResponseDto);
        }
        return returnList;
    }
}
