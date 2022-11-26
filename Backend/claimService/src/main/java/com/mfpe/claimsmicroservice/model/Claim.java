package com.mfpe.claimsmicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "claims")

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Claim {

	@Id
    @Column(name="CID")
	private @Getter @Setter String claimId;
	
    @Column(name="Status")	
	private @Getter @Setter String status;
    
    @Column(name="Description")	
	private @Getter @Setter String description;
    
    @Column(name="Remarks")	
	private @Getter @Setter String remarks;
    
    @Column(name="Claim_Amount")	
	private  @Getter @Setter double claimAmount;

   
    @Column(name="hospitalId")
    private @Getter @Setter String hospitalId;
    
  
    @Column(name="benefitId")
    private @Getter @Setter String benefitId;
    
    @Column(name="PolicyId")
    private @Getter @Setter String policyId;
    
    @Column(name="MemberId")
    private @Getter @Setter String memberId;
    
    
}
