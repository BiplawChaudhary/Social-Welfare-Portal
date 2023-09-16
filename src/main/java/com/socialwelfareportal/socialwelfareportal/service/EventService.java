package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.EventRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;

import java.text.ParseException;

public interface EventService {
    public Events getEventById(Integer id);
    public void createEvent(EventRequestDto eventRequestDto) throws ParseException;
}
