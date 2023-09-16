package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
import com.socialwelfareportal.socialwelfareportal.service.impl.GrantRequestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/grant")
public class GrantController {
    //Injecting the serviec
    private final GrantRequestServiceImpl grantRequestService;

    //Grant Homepage
    @GetMapping("/")
    public String getRegister(){
        return "/main/grantrequest/grantController";
    }

    //Method to get the grantrequest form
    @GetMapping("/register")
    public String getGrantRequestForm(Model model){
        //Adding the blank model
        model.addAttribute("grantdto", new GrantRequestDto());
        //REturning the page
        return "/main/grantrequest/grantrequestform";
    }

    @PostMapping("/register")
    public String saveGrantRequest(GrantRequestDto dto){
        grantRequestService.requestForGrant(dto);
        return "redirect:/grant";
    }
}
