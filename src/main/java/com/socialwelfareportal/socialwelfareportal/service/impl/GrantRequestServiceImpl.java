package com.socialwelfareportal.socialwelfareportal.service.impl;


import com.socialwelfareportal.socialwelfareportal.dto.requestdto.GrantRequestDto;
import com.socialwelfareportal.socialwelfareportal.dto.responsedto.GrantResponseDto;
import com.socialwelfareportal.socialwelfareportal.entity.GrantDetails;
import com.socialwelfareportal.socialwelfareportal.entity.Status;
import com.socialwelfareportal.socialwelfareportal.repo.GrantDetailsRepo;
import com.socialwelfareportal.socialwelfareportal.service.GrantRequestService;
import com.socialwelfareportal.socialwelfareportal.service.Others.MiscService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrantRequestServiceImpl implements GrantRequestService {

    //injecting the grant details
    private final GrantDetailsRepo grantDetailsRepo;
    private final MiscService miscService;

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
    public GrantDetails requestForGrant(GrantRequestDto dto) {
        //Creating a new Grant Request
        GrantDetails newGrantRequest = new GrantDetails(dto);

        newGrantRequest.setUser(miscService.getLoggedInUser());
        //Saving the grant details to the table
        return grantDetailsRepo.save(newGrantRequest);
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

    @Override
    public void approveTheRequest(Integer id) {
        GrantDetails foundDetails = grantDetailsRepo.findById(id).get();
        foundDetails.setStatus(Status.approved);
        grantDetailsRepo.save(foundDetails);
    }

    @Override
    public void rejectTheRequest(Integer id) {
        GrantDetails foundDetails = grantDetailsRepo.findById(id).get();
        foundDetails.setStatus(Status.declined);
        grantDetailsRepo.save(foundDetails);
    }


    //Get the grants of the logged in user.
    @Override
    public List<GrantResponseDto> getGrantsOfParticularUser(Integer id) {
        return null;
    }

    @Override
    public List<GrantResponseDto> getpendingGrantRequest() {
        List<GrantResponseDto> foundList = new ArrayList<>();

        List<GrantDetails> allPending = grantDetailsRepo.findByStatus(Status.pending);

        for(var each: allPending){
            foundList.add(new GrantResponseDto(each));
        }
        if(foundList.size() >0){
            System.out.println("Found the size.");
        }
        return foundList;
    }


    @Override
    public List<GrantResponseDto> getSearchResult(String name) {
        List<GrantResponseDto> foundList = new ArrayList<>();

        List<GrantDetails> allPending = grantDetailsRepo.findByNameContainingIgnoreCase(name);

        for(var each: allPending){
            foundList.add(new GrantResponseDto(each));
        }

        return foundList;
    }
}
