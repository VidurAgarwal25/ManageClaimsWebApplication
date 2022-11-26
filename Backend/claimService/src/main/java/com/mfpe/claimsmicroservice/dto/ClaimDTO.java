package com.mfpe.claimsmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDTO {

	private @Getter @Setter String claimId;

	private @Getter @Setter String status;

	private @Getter @Setter String description;

	private @Getter @Setter String remarks;
	
	private @Getter @Setter double billedAmount;

	private @Getter @Setter double claimAmount;

	private @Getter @Setter String hospitalId;

	private @Getter @Setter String benefitId;

	private @Getter @Setter String policyId;

	private @Getter @Setter String memberId;
}
