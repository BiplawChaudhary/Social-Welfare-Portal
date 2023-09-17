package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.entity.Budget;

import java.util.List;

public interface BudgetService {
    List<Budget> getAllBudgets();

    Budget getBudgetById(Integer id);

    Budget saveBudget(Budget budget);

    Budget updateBudgetDetails(Integer id, Budget dto);

    void removeBudget(Integer id);
}
