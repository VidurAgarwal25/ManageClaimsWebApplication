package com.mfpe.memberService.dto;



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
public class ClaimStatusDTO {
	private @Getter @Setter String claimId;
	private @Getter @Setter String claimStatus;
	private @Getter @Setter String claimDescription;
	

}
