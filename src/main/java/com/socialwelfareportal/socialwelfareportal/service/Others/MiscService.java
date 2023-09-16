package com.socialwelfareportal.socialwelfareportal.service.Others;



import com.socialwelfareportal.socialwelfareportal.entity.User;
import com.socialwelfareportal.socialwelfareportal.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class MiscService {
    private final UserRepo userRepo;

    //Function to check if the user is logged in or not
    //If the user is logged in return true, else return false
    public boolean isUserLoggedIn() {
        // Get the authentication object from the SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user is authenticated
        return authentication != null && authentication.isAuthenticated();
    }

    public User getLoggedInUser(){
        //Getting the username of the authenticated user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        //Finding the user
       return userRepo.getUserByUsername(username);

    }



}
