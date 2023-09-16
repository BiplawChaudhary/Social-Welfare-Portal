package com.socialwelfareportal.socialwelfareportal.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NgoDetailsRequestDto {

    private String panNumber;

    private String swcNumber;

    private String regNumber;

    private String name;

    private String address;

    private String contact;

    private String email;
}
