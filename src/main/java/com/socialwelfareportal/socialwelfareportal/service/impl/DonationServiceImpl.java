package com.socialwelfareportal.socialwelfareportal.service.impl;

import com.socialwelfareportal.socialwelfareportal.entity.Donation;
import com.socialwelfareportal.socialwelfareportal.repo.DonationRepo;
import com.socialwelfareportal.socialwelfareportal.service.DonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationServiceImpl implements DonationService {
    private final DonationRepo donationRepo;


    @Override
    public Integer getTotalDonationAmount() {
        List<Donation> allDonation = donationRepo.findAll();
        Integer totalAmt = 0;

        for(var each: allDonation){
            totalAmt += each.getAmount();
        }

        return totalAmt;
    }
}
