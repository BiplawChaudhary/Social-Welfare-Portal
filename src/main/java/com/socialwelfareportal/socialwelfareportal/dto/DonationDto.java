package com.socialwelfareportal.socialwelfareportal.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonationDto {

	private Integer price;
	private String currency;
	private String method;
	private String intent;
	private String description;
	private String donor;
	private String phone;
	private String email;

	public String getCurrency() {
		return "USD";
	}

	public String getMethod() {
		return "paypal";
	}

	public String getIntent() {
		return "sale";
	}
}
