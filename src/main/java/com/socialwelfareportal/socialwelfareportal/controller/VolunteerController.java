package com.socialwelfareportal.socialwelfareportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class VolunteerController {
    //Route that returns volunteer for event form
    @GetMapping("/event/register")
    public String getRegisterPage(Model model){
        model.addAllAttributes("volunteerDto", new VolunteerDto());
        return "/main/volunteer/register";
    }

    @PostMapping("/event/register")
    public String registerVolunteer(){
        return "redirect:/";
    }
}
