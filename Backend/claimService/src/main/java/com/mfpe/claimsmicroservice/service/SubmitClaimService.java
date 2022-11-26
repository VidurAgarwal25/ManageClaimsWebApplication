package com.mfpe.claimsmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.claimsmicroservice.client.PolicyClient;
import com.mfpe.claimsmicroservice.dto.BenefitsDTO;
import com.mfpe.claimsmicroservice.dto.ClaimAmountDTO;
import com.mfpe.claimsmicroservice.dto.ClaimDTO;
import com.mfpe.claimsmicroservice.dto.ClaimStatusDTO;
import com.mfpe.claimsmicroservice.dto.ProviderDTO;
import com.mfpe.claimsmicroservice.exceptions.PolicyException;
import com.mfpe.claimsmicroservice.model.Benefits;
import com.mfpe.claimsmicroservice.model.Claim;
import com.mfpe.claimsmicroservice.model.Hospital;
import com.mfpe.claimsmicroservice.repository.ClaimRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SubmitClaimService {
	@Autowired                           // points to dependencies
	private ClaimRepo claimRepo;
	@Autowired
	private PolicyClient policyClient;

	private boolean checkProvider(ClaimDTO claimDTO, String token) {
		
		ProviderDTO providerDTO = policyClient.getChainOfProviders(claimDTO.getPolicyId(), token).getBody();
		/*
		 * Policy Id entered by user will be used to check what hospitals come under these particular policy
		 * http://localhost:8002/policy/getChainOfProviders/P1002
		 * ProviderDto will store datatype of class Hospital
		 * class Hospital has three variables for particular policy id:- hospitalid, hospital name, and its location
		*/
			log.info("came here");
			//log.info(providerDTO);
			//log.info(providerDTO.getProviders());
			if (providerDTO !=null && providerDTO.getProviders() != null) {
				/*
				 * if input hospital id matches with any of the hospital id generated from PolicyClient then 
				 * it will return true which marks hospitalflag true
				 * otherwise false
				*/
			for (Hospital hospitalDetails : providerDTO.getProviders()) {
				if (claimDTO.getHospitalId().equalsIgnoreCase(hospitalDetails.getHospitalId())) {
					return true;
				}
			}
			}
		
		return false;
	}

	private boolean checkBenefit(ClaimDTO claimDTO, String token) {
		BenefitsDTO benefitsDTO = policyClient.getEligibleBenefits(claimDTO.getPolicyId(), claimDTO.getMemberId(), token).getBody();
		/*
		 * Policy Id & memberId entered by user will be used to get benefits of particular policy to a particular member
		 * http://localhost:8002/policy/getEligibleBenefits/P1001/M102
		 * benefitsDto will store datatype of class Benefit
		 * class Benefit has two variables for particular policy id and memeber id:- benefitId, benefitName
		*/
		if (benefitsDTO != null &&  benefitsDTO.getBenefits() !=null) {
			/*
			 * if input benefit id matches with any of the benefit id generated from PolicyClient then 
			 * it will return true which marks benefitflag true
			 * otherwise false
			*/
		for (Benefits benefits : benefitsDTO.getBenefits()) {
			if (claimDTO.getBenefitId().equalsIgnoreCase(benefits.getBenefitId())) {
				return true;
			}
		}
		}
		return false;
	}

	private boolean checkAmount(ClaimDTO claimDTO, String token) {
		ClaimAmountDTO claimAmountDTO = policyClient.getEligibleAmount(claimDTO.getPolicyId(), claimDTO.getMemberId(), token).getBody();
		/*
		 * Policy Id & memberId entered by user will be used to get eligible amount of particular policy to a particular member
		 * http://localhost:8002/policy/getEligibleClaimAmount/P1001/M101
		 * claimAmountDto will store amount that can be claimed of particular policy by a member
		 
		*/
		if (claimAmountDTO != null) {
		/*
		*if amount input by user is less than he can claim from policy then return true which marks amountFlag true
		*otherwise false
	   */
	
		return (claimDTO.getClaimAmount() <= claimAmountDTO.getEligibleAmount());
		}
		return false;
	}

	public ResponseEntity<ClaimStatusDTO> submitClaim(ClaimDTO claimDTO, String token) throws NullPointerException {
		//if all of them will be true then only message of "Pending action" will be displayed otherwise "insufficient details"
		boolean hospitalFlag = false;   
		boolean benefitFlag = false;
		boolean amountFlag = false;
		try {
		log.info("inside the submit claim service method : BEGIN");
		log.info("checking the provider : BEGIN");
		hospitalFlag = checkProvider(claimDTO, token);    //function returns boolean values
		log.info("checking of provider : ENDED");

		log.info("checking the Benefit : BEGIN");
		benefitFlag = checkBenefit(claimDTO, token);		//function returns boolean values
		log.info("checking of Benefit : ENDED");

		log.info("checking the Amount : BEGIN");
		amountFlag = checkAmount(claimDTO, token);			//function returns boolean values
		log.info("checking of provider : ENDED");
		}catch(PolicyException pe) {
			throw new PolicyException("Policy Serivce is Not working Properly");	// throws an exception
		}
		log.info("creating claim and setting the status : BEGIN");
		//Claim class will have nine fields along with their getters and setters method
		//seven fields value will be set by the values entered by a user
		Claim claim = new Claim();
		claim.setClaimId(claimDTO.getClaimId());
		claim.setBenefitId(claimDTO.getBenefitId());
		claim.setClaimAmount(claim.getClaimAmount());
		claim.setHospitalId(claimDTO.getHospitalId());
		claim.setMemberId(claimDTO.getMemberId());
		claim.setPolicyId(claimDTO.getPolicyId());
		claim.setRemarks(claim.getRemarks());
		if (hospitalFlag && benefitFlag && amountFlag) {
			claim.setStatus("Pending Action");
			claim.setDescription("All the fields are successfully verified! Please wait for furthur action");
		} else {
			claim.setStatus("Claim Rejected");
			if (!hospitalFlag) {
				claim.setDescription("Providers Details are not valid");
			} else if (!benefitFlag) {
				claim.setDescription("Benefits Details are not valid");
			} else {
				claim.setDescription("Claim amount is not valid");
			}
		}
		log.info("setting the status : ENDED");
		if (hospitalFlag && benefitFlag && amountFlag) {
			claimRepo.save(claim);  //claimrepo is an interface extending jpa repository
		}

		ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO(); //ClaimStatusDTO is storing the values of status, description and claim id 
		claimStatusDTO.setClaimStatus(claim.getStatus());
		claimStatusDTO.setClaimDescription(claim.getDescription());
		claimStatusDTO.setClaimId(claim.getClaimId());
		return new ResponseEntity<>(claimStatusDTO, HttpStatus.OK);
	}

}
