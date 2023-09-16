package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import com.socialwelfareportal.socialwelfareportal.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class VolunteerController {
    @Autowired
    VolunteerService volunteerService;

    //Route that returns volunteer for event form
    @GetMapping("/events/register")
    public String getRegisterPage(Model model){
        VolunteerRequestDto volunteerRequestDto = new VolunteerRequestDto();
        model.addAttribute("volunteerRequestDto", volunteerRequestDto);
        return "/main/volunteer/register";
    }

    //Save form data
    @PostMapping("/events/register")
    public String registerVolunteer(@ModelAttribute("volunteerRequestDto")VolunteerRequestDto volunteerRequestDto){
        volunteerService.createVolunteer(volunteerRequestDto);
        return "redirect:/events";
    }
}
