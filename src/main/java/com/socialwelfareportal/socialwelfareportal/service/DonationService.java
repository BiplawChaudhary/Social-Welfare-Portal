package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.DonationDto;

public interface DonationService {
    Integer getTotalDonationAmount();
    void createDonation(DonationDto donationDto);
}
