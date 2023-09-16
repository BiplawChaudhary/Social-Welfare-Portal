package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.Events;
import com.socialwelfareportal.socialwelfareportal.service.EventService;
import com.socialwelfareportal.socialwelfareportal.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class VolunteerController {
    @Autowired
    VolunteerService volunteerService;

    @Autowired
    EventService eventService;

    //Route that returns volunteer for event form
    @GetMapping("/events/register/{id}")
    public String getRegisterPage(@PathVariable Integer id, Model model){
        Events events = eventService.getEvent(id).get();
        VolunteerRequestDto volunteerRequestDto = new VolunteerRequestDto();
        volunteerRequestDto.setEvent_id(id);
        model.addAttribute("event",events);
        model.addAttribute("volunteerRequestDto", volunteerRequestDto);
        return "/main/volunteer/register";
    }

    //Save form data
    @PostMapping("/events/register")
    public String registerVolunteer(@ModelAttribute("volunteerRequestDto")VolunteerRequestDto volunteerRequestDto){
        volunteerService.createVolunteer(volunteerRequestDto);
        return "redirect:/events";
    }

    @GetMapping("/volunteer")
    public String volunteer(){
        return "/main/volunteer/volunteering";
    }
}
