package com.socialwelfareportal.socialwelfareportal.security;



import com.socialwelfareportal.socialwelfareportal.entity.User;
import com.socialwelfareportal.socialwelfareportal.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepo.getUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Username Not found.");
        }
        return user;
    }
}
