package com.mfpe.claimsmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClaimStatusDTO {
	private @Getter @Setter String claimId;
	private @Getter @Setter String claimStatus;
	
	private @Getter @Setter String claimDescription;

}