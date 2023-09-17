package com.socialwelfareportal.socialwelfareportal.service.impl;

import com.socialwelfareportal.socialwelfareportal.entity.Budget;
import com.socialwelfareportal.socialwelfareportal.repo.BudgetRepo;
import com.socialwelfareportal.socialwelfareportal.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepo budgetRepo;


    @Override
    public List<Budget> getAllBudgets() {
        return budgetRepo.findAll();
    }

    @Override
    public Budget getBudgetById(Integer id) {
        return budgetRepo.findById(id).get();
    }

    @Override
    public Budget saveBudget(Budget budget) {
        return budgetRepo.save(budget);
    }

    @Override
    public Budget updateBudgetDetails(Integer id, Budget dto) {
        Budget foundBuget = budgetRepo.findById(id).get();

        foundBuget.setFund(dto.getFund());
        foundBuget.setSector(dto.getSector());
        return budgetRepo.save(foundBuget);
    }

    @Override
    public void removeBudget(Integer id) {
        budgetRepo.deleteById(id);
    }
}
