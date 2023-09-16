package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.VolunteerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class VolunteerController {
    //Route that returns volunteer for event form
    @GetMapping("/event/register")
    public String getRegisterPage(Model model){
        VolunteerRequestDto volunteerRequestDto = new VolunteerRequestDto();
        model.addAttribute("volunteerRequestDto", volunteerRequestDto);
        return "/main/volunteer/register";
    }

    @PostMapping("/event/register")
    public String registerVolunteer(@ModelAttribute("volunteerRequestDto")VolunteerRequestDto volunteerRequestDto){
        return "redirect:/";
    }
}
