package com.socialwelfareportal.socialwelfareportal.conf;

import com.socialwelfareportal.socialwelfareportal.entity.Role;
import com.socialwelfareportal.socialwelfareportal.entity.User;
import com.socialwelfareportal.socialwelfareportal.repo.RoleRepo;
import com.socialwelfareportal.socialwelfareportal.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class InitDbConfig {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;



    @PostConstruct
    public void doEntries(){
        if(roleRepo.findAll().size() == 0){
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            Role savedAdmin = roleRepo.save(adminRole);

            Role userRole = new Role();
            userRole.setName("USER");
            Role savedUser = roleRepo.save(userRole);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(encoder.encode("admin"));
            adminUser.setRoles(Arrays.asList(savedAdmin));
            userRepo.save(adminUser);

            User normalUser = new User();
            normalUser.setUsername("test");
            normalUser.setPassword(encoder.encode("test"));
            normalUser.setRoles(Arrays.asList(savedUser));
            userRepo.save(normalUser);
        }
    }

}
