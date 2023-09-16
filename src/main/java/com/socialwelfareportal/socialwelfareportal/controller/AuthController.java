package com.socialwelfareportal.socialwelfareportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/login")
    public String getLoginForm(){
        return "/main/authPages/login";
    }
}
