package com.socialwelfareportal.socialwelfareportal.service.impl;


import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.GrantResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.GrantDetails;
import com.socialwelfareportal.socialwelfareportal.repo.GrantDetailsRepo;
import com.socialwelfareportal.socialwelfareportal.service.GrantRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrantRequestServiceImpl implements GrantRequestService {

    //injecting the grant details
    private final GrantDetailsRepo grantDetailsRepo;


    //Returns all grants
    @Override
    public List<GrantResponseDto> getAllGrants() {
        //Sending to fronted using this fetched data in list
        List<GrantResponseDto> allGrantDetails  = new ArrayList<>();

        //Fetching all the data from DB
        List<GrantDetails> allDetails = grantDetailsRepo.findAll();

        //Changing the database value intoo the response value
        for(GrantDetails each: allDetails){
            allGrantDetails.add(new GrantResponseDto(each));
        }

        //Returning the grant details
        return allGrantDetails;
    }

    //Get the grant by id
    @Override
    public GrantResponseDto findGrantById(Integer id) {
        GrantDetails foundDetails = grantDetailsRepo.findById(id).get();

//        if(foundDetails == null){
//            throw Exception("Value not found in the database.");
//        }
        return new GrantResponseDto();

    }

    //Add a grant request to table.
    @Override
    public GrantResponseDto requestForGrant(GrantRequestDto dto) {
        //Creating a new Grant Request
        GrantDetails newGrantRequest = new GrantDetails(dto);

        //Saving the grant details to the table
        return new GrantResponseDto(grantDetailsRepo.save(newGrantRequest));
    }

    //Cancel the grant request
    @Override
    public void cancelTheRequest(Integer id) {
        grantDetailsRepo.deleteById(id);

    }

    //Update the request details
    @Override
    public GrantResponseDto updateTheRequest(Integer id, GrantRequestDto dto) {
        GrantDetails foundDetails = grantDetailsRepo.findById(id).get();

        foundDetails.setDescription(dto.getDescription());
        foundDetails.setFiscalYear(dto.getFiscalYear());
        foundDetails.setName(dto.getName());
        foundDetails.setNoOfIndividual(dto.getNoOfIndividual());

        return new GrantResponseDto(grantDetailsRepo.save(foundDetails));
    }
}