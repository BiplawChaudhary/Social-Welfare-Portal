package com.socialwelfareportal.socialwelfareportal.repo;

import com.socialwelfareportal.socialwelfareportal.entity.GrantDetails;
import com.socialwelfareportal.socialwelfareportal.entity.Status;
import com.socialwelfareportal.socialwelfareportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrantDetailsRepo extends JpaRepository<GrantDetails, Integer> {

    List<GrantDetails> findByStatus(Status status);

    List<GrantDetails> findByNameContainingIgnoreCase(String name);

    List<GrantDetails> findByUser(User user);

}
