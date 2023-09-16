package com.socialwelfareportal.socialwelfareportal.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controller that handles the main functionality of the users.
@Controller
@RequiredArgsConstructor
public class MainController {

    //Route that returns the index page
    @GetMapping("/")
    public String getHomePage(){
        //Pass the value to the index page below this line:

        //Returning the main page
        return "/main/index";
    }
}
