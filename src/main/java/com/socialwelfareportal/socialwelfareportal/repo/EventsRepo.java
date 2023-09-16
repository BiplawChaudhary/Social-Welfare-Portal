package com.socialwelfareportal.socialwelfareportal.repo;

import com.socialwelfareportal.socialwelfareportal.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepo extends JpaRepository<Integer, Events> {
}
