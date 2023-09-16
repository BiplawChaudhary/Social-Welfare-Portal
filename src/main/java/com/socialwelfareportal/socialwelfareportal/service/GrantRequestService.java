package com.socialwelfareportal.socialwelfareportal.service;

import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.GrantResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.GrantDetails;

import java.util.List;

public interface GrantRequestService {

    List<GrantResponseDto> getAllGrants();

    GrantResponseDto findGrantById(Integer id);

    GrantResponseDto requestForGrant(GrantRequestDto dto);

    void cancelTheRequest(Integer id);

    GrantResponseDto updateTheRequest(Integer id, GrantRequestDto dto);

    List<GrantResponseDto> getGrantsOfParticularUser(Integer id);

}
