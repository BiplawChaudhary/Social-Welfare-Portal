package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.EventRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;
import com.socialwelfareportal.socialwelfareportal.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;

@Controller
@RequiredArgsConstructor
public class EventsController {
    @Autowired
    EventService eventService;

    //Route that returns events page
    @GetMapping("/events")
    public String returnEvents(Model model){
        model.addAttribute("events",eventService.getAllEvents());
        return "/main/events/events";
    }

    //Add events page
    @GetMapping("/events/add")
    public String addEvents(Model model){
        model.addAttribute("eventRequestDto", new EventRequestDto());
        return "/main/events/add";
    }

    //Post form data for events
    @PostMapping("/events/add")
    public String addEventsPost(@ModelAttribute("eventRequestDto")EventRequestDto eventRequestDto) throws ParseException {
        eventService.createEvent(eventRequestDto);
        return "redirect:/events";
    }
}
