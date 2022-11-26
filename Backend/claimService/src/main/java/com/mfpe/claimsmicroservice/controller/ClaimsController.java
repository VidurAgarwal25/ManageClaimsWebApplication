package com.mfpe.claimsmicroservice.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.claimsmicroservice.client.AuthClient;
import com.mfpe.claimsmicroservice.dto.ClaimDTO;
import com.mfpe.claimsmicroservice.dto.ClaimStatusDTO;
import com.mfpe.claimsmicroservice.exceptions.InvalidClaimIdException;
import com.mfpe.claimsmicroservice.exceptions.InvalidTokenException;
import com.mfpe.claimsmicroservice.service.ClaimStatusService;
import com.mfpe.claimsmicroservice.service.SubmitClaimService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController 	//allows the class to handle the requests made by client
@Slf4j          	//causes lombok to generate a logger field
@RequestMapping 	//used to map http requests to handler methods of mvc and rest controllers
@Api(value = "For dealing with claim ") //all methods will be considered as methods of api
public class ClaimsController {

	@Autowired    									//points a dependency
	private ClaimStatusService claimStatusService;
	@Autowired
	private SubmitClaimService submitClaimService;
	
	@Autowired
	private AuthClient authClient;
	
	@GetMapping(path="/getClaimStatus/{claimId}")      // http://localhost:8003/getClaimStatus/2/P1001/M101
	/*
	 * Input has three fields claimid
	 * Output has two fields claimStatus, claimDescription
	*/
	
	//HTTP RESPONSE FROM ClaimStatusDTO
	
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable("claimId") String claimId,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidClaimIdException,InvalidTokenException {
		log.info(token);
		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		
		log.info("inside the get Claim Status : BEGIN");
		//ClaimStatusDto has getters & setters of two output fields claim status and claim description
		return claimStatusService.getClaimStatus(claimId); 
	}
	

	
	@PostMapping(path ="/submitClaim")       // http://localhost:8003/submitClaim
	/*
	 * Input has seven fields:-
	 * claimId, hospitalId, remarks, memberId, benefitId, policyId, claimAmount
	 * Output has two fields:-
	 * claimStatus, claimDescription
	*/
	
	//HTTP RESPONSE FROM ClaimStatusDTO
	
	//ClaimDto has getters & setters of all nine fields and stores the values of seven input fields passed as input in post request
	public ResponseEntity<ClaimStatusDTO> submitClaim(@RequestBody ClaimDTO claimDTO,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidTokenException,NullPointerException {
		log.info(token);
		//checks the validity of token
		//if isValidStatus returns false that means token is inavlid or has been expired, throwing exception
		if (!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		log.info("inside the submit Claim : BEGIN");
		// if token is valid 
		//returns ClaimStatusDTO response entity having two fields status,description
		return submitClaimService.submitClaim(claimDTO,token); 
	}
	
}
