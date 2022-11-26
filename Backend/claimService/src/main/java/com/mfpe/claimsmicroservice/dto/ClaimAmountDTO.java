package com.mfpe.claimsmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ClaimAmountDTO {
	
	@JsonProperty
	private @Getter @Setter double eligibleAmount;

	@JsonIgnore
	public double getEligibleAmount() {
		return eligibleAmount;
	}
	
	@JsonIgnore
	public void setEligibleAmount(double eligibleAmount) {
		this.eligibleAmount = eligibleAmount;
	}
	
	@JsonIgnore
	public ClaimAmountDTO(double eligibleAmount) {
		super();
		this.eligibleAmount = eligibleAmount;
	}
	
	
	
	
	

}