package com.socialwelfareportal.socialwelfareportal.controller;


import com.socialwelfareportal.socialwelfareportal.repo.DonationRepo;
import com.socialwelfareportal.socialwelfareportal.repo.EventsRepo;
import com.socialwelfareportal.socialwelfareportal.repo.GrantDetailsRepo;
import com.socialwelfareportal.socialwelfareportal.service.DonationService;
import com.socialwelfareportal.socialwelfareportal.service.NgoDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller that handles the main functionality of the users.
@Controller
@RequiredArgsConstructor
public class MainController {
    //Injecting the Services
    private final DonationService donationService;
    private final NgoDetailsService ngoDetailsService;
    private final DonationRepo donationRepo;
    private final GrantDetailsRepo grantDetailsRepo;
    private final EventsRepo eventsRepo;


    //Route that returns the index page
    @GetMapping("/")
    public String getHomePage(Model model){
        //Pass the value to the index page below this line:
        model.addAttribute("donationAmount",donationService.getTotalDonationAmount());
        model.addAttribute("ngoNumber", ngoDetailsService.getTotalNgoNumber());
        //Returning the main page
        return "/main/home/index";
    }

    //Returns the about page
    @GetMapping("/about")
    public String getAboutpage(){
        return "/main/home/about";
    }

    //Returns the Contatct Page
    @GetMapping("/contact")
    public String getContactPage(){
        return "/main/home/contact";
    }

    @GetMapping("/track")
    public String getFundDetails(Model model){
        model.addAttribute("donations",donationRepo.findAll());
        model.addAttribute("grants",grantDetailsRepo.findAll());
        model.addAttribute("events",eventsRepo.findAll());
        return "/main/home/tracker";
    }
    
}
