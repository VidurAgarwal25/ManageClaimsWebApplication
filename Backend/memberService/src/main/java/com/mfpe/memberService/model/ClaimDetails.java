package com.mfpe.memberService.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClaimDetails {
	

	private @Getter @Setter String claimId;
	
	private @Getter @Setter String status;

	private @Getter @Setter String description;
    

	private @Getter @Setter String remarks;
	
	private @Getter @Setter double claimAmount;


    private @Getter @Setter String hospitalId;
    

    private @Getter @Setter String benefitId;
    

    private @Getter @Setter String policyId;
    

    private @Getter @Setter String memberId;
	
}
