package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.NgoDetailsRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.NgoDetails;

import java.util.List;

public interface NgoDetailsService {
    List<NgoDetails> getAllNgoDetails();

    NgoDetails findNgoDetailsById(Integer id);

    NgoDetails saveNgoDetails(NgoDetailsRequestDto dto);

    Integer getTotalNgoNumber();


}
