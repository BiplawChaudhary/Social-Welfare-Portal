package com.socialwelfareportal.socialwelfareportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class VolunteerController {
    //Route that returns volunteer for event form
    @GetMapping("/event/register")
    public String getRegisterPage(){
        return "/main/volunteer/register";
    }
}
