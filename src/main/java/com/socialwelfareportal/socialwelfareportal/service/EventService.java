package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.EventRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.EventResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Optional<Events> getEvent(Integer id);
    void createEvent(EventRequestDto eventRequestDto) throws ParseException;
    List<EventResponseDto> getAllEvents();
}
