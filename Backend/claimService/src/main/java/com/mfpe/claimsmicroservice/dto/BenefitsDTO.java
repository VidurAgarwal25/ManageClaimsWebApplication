package com.mfpe.claimsmicroservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfpe.claimsmicroservice.model.Benefits;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter
public class BenefitsDTO {
	
	@JsonProperty
	 private @Getter @Setter List<Benefits> benefits;

	@JsonIgnore
	public List<Benefits> getBenefits() {
		return benefits;
	}

	@JsonIgnore
	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}

	@JsonIgnore
	public BenefitsDTO(List<Benefits> benefits) {
		super();
		this.benefits = benefits;
	}
	
	
	
	
	

}