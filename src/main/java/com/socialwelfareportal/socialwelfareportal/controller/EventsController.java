package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.EventRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.EventResponseDto;
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventsController {
    @Autowired
    private final EventService eventService;

    //Route that returns events page
    @GetMapping("/events")
    public String returnEvents(Model model) throws ParseException {
        List<EventResponseDto> allEvents = eventService.getAllEvents();
        List<EventResponseDto> currentEvents = new ArrayList<>();
        List<EventResponseDto> expiredEvents = new ArrayList<>();
        for (EventResponseDto event:allEvents) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy, hh:mm a");
            Date parsedDate = dateFormat.parse(event.getDate());
            Date currentDate = new Date();
            if(parsedDate.after(currentDate)){
                currentEvents.add(event);
            }
            else{
                expiredEvents.add(event);
            }
        }
        model.addAttribute("currentEvents", currentEvents);
        model.addAttribute("expiredEvents", expiredEvents);
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
