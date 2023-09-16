package com.socialwelfareportal.socialwelfareportal.dto.responsedto;


import com.socialwelfareportal.socialwelfareportal.dto.requestdto.NgoDetailsRequestDto;
import com.socialwelfareportal.socialwelfareportal.entity.NgoDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NgoDetailsResponseDto {
    private Integer id;

    private String panNumber;

    private String swcNumber;

    private String regNumber;

    private String name;

    private String address;

    private String contact;

    private String email;

    public NgoDetailsResponseDto(NgoDetails dto){
        this.id = dto.getId();
        this.panNumber = dto.getPanNumber();
        this.swcNumber = dto.getSwcNumber();
        this.regNumber = dto.getRegNumber();
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.contact = dto.getContact();
        this.email = dto.getEmail();
    }
}
