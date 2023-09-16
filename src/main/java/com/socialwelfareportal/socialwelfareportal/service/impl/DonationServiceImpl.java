package com.socialwelfareportal.socialwelfareportal.service.impl;

import com.socialwelfareportal.socialwelfareportal.dto.DonationDto;
import com.socialwelfareportal.socialwelfareportal.entity.Donation;
import com.socialwelfareportal.socialwelfareportal.repo.DonationRepo;
import com.socialwelfareportal.socialwelfareportal.service.DonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Override
    public void createDonation(DonationDto donationDto) {
        Donation donation = new Donation();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());
        donation.setDate(currentDate);
        donation.setDonor(donationDto.getDonor());
        donation.setPhone(donationDto.getPhone());
        donation.setEmail(donationDto.getEmail());
        donation.setAmount(donationDto.getPrice());
        donation.setDescription(donationDto.getDescription());
        donationRepo.save(donation);
    }
}
