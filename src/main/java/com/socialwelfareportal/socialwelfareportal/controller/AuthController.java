package com.socialwelfareportal.socialwelfareportal.controller;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.NgoDetailsRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.User;
import com.socialwelfareportal.socialwelfareportal.repo.UserRepo;
import com.socialwelfareportal.socialwelfareportal.service.NgoDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private final NgoDetailsService ngoDetailsService;

    @Autowired
    private final UserRepo userRepo;

    @GetMapping("/login")
    public String getLoginForm(){
        return "/main/authPages/login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("ngo", new NgoDetailsRequestDto());
        model.addAttribute("user",new User());
        return "/main/authPages/ngoregister";
    }

    @PostMapping("/register")
    public String saveNgo(@ModelAttribute("ngo")NgoDetailsRequestDto ngoDetailsRequestDto, @ModelAttribute("user") User user){
        ngoDetailsService.saveNgoDetails(ngoDetailsRequestDto);
        user.setUsername(ngoDetailsRequestDto.getSwcNumber());
        String pass = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(pass));
        userRepo.save(user);
        return "redirect:/login";
    }
}
