package com.socialwelfareportal.socialwelfareportal.dto.responsedto;

import com.socialwelfareportal.socialwelfareportal.entity.GrantDetails;
import com.socialwelfareportal.socialwelfareportal.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrantResponseDto {
    private Integer id;

    private String fiscalYear;

    private String description;

    private String name;

    private Integer noOfIndividual;

    private Status status;

    public GrantResponseDto(GrantDetails dto){
        this.id = dto.getId();
        this.fiscalYear =dto.getFiscalYear();
        this.description = dto.getDescription();
        this.name = dto.getName();
        this.noOfIndividual = dto.getNoOfIndividual();
        this.status = dto.getStatus();
    }

}
