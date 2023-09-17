package com.socialwelfareportal.socialwelfareportal.repo;

import com.socialwelfareportal.socialwelfareportal.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepo extends JpaRepository<Budget, Integer> {
}
