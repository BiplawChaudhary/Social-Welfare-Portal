package com.socialwelfareportal.socialwelfareportal.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GrantRequestDto {
    private String fiscalYear;

    private String description;

    private String name;

    private Integer noOfIndividual;
    private Integer amount;
}
