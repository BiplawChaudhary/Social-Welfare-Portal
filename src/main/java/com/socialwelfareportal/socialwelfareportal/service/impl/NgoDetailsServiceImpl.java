package com.socialwelfareportal.socialwelfareportal.service.impl;


import com.socialwelfareportal.socialwelfareportal.dto.requestdto.NgoDetailsRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.NgoDetails;
import com.socialwelfareportal.socialwelfareportal.repo.NgoDetailsRepo;
import com.socialwelfareportal.socialwelfareportal.service.NgoDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NgoDetailsServiceImpl implements NgoDetailsService {
    private final NgoDetailsRepo ngoDetailsRepo;


    @Override
    public List<NgoDetails> getAllNgoDetails() {
        return null;
    }

    @Override
    public NgoDetails findNgoDetailsById(Integer id) {
        return null;
    }

    @Override
    public NgoDetails saveNgoDetails(NgoDetailsRequestDto dto) {
        return null;
    }

    @Override
    public Integer getTotalNgoNumber() {
        return ngoDetailsRepo.findAll().size();
    }
}
