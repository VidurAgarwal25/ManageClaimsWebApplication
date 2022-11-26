package com.mfpe.memberService.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.memberService.client.AuthClient;
import com.mfpe.memberService.dto.ClaimStatusDTO;
import com.mfpe.memberService.exceptions.InvalidTokenException;
import com.mfpe.memberService.model.Bills;
import com.mfpe.memberService.model.ClaimDetails;
import com.mfpe.memberService.service.ClaimStatusAndDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
@RequestMapping
@Api(value = "Member service endpoint")
@CrossOrigin
public class MemberController { 
    
    @Autowired
    private ClaimStatusAndDetails ClaimStatusAndDetails;
    
     @Autowired
     private AuthClient authClient;
     
     private String msg = "Token is either expired or invalid...";
    
    @ApiOperation(value = "to get the Bills for the User")
    @GetMapping(value="/viewBills/{memberId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bills> getBills( @PathVariable("memberId") String memberId,
            @RequestHeader(name = "Authorization", required = true)String token) throws InvalidTokenException
    {
        log.info("IgetBills EndPoint : Begin");
        
        // Checking the user validity
    	if (!authClient.getsValidity(token).isValidStatus()) {
			
			throw new InvalidTokenException(msg);
		}
	
    	log.info("Inside the getBills EndPoint : Ended");
        return new ResponseEntity<>( ClaimStatusAndDetails.fetchBills(memberId), HttpStatus.OK);
    }
    
    // getClaimStatus api used for getting the claim status and getting the validated information by checking the below 
    //following condition
    @ApiOperation(value = "To get the claim Status For Given Id")
    @GetMapping(value="/getClaimStatus/{claimId}", produces = "application/json")
    public ResponseEntity<ClaimStatusDTO> returnClaimStatus(@PathVariable("claimId") String claimId,@RequestHeader(name = "Authorization", required = true)String token) throws InvalidTokenException
    {
        
        log.info("getClaimStatus EndPoint : Begin");
        
        // Checking the user validity
        //In this condition getsValidity function from the AuthClient of member service call particular 
        //function and check the validation status 
        //In validity function we are returning the data as validatingDTO (data transfer objects) by setting and getting the values
        // If there is any error in validating the token then it hits the InvalidTokenException function which is class mentioned 
        // in exceptions section. This returns a error message 
     
        if (!authClient.getsValidity(token).isValidStatus())  {
            
            throw new InvalidTokenException(msg);
        }
        
        log.info("Inside the getClaimStatus EndPoint : Ended");
        return new ResponseEntity<>( ClaimStatusAndDetails.fetchClaimStatus(claimId, token), HttpStatus.OK);          
    }
    
    // submitClaim api used for displaying the data as my required and validating them 
    // If there is any error in validating the token then it hits the InvalidTokenException function which is class mentioned 
    // in exceptions section. This returns a error message 
    @PostMapping(value="/submitClaim", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "To Submit the Claim", response = ClaimStatusDTO.class, httpMethod = "POST")
    public ResponseEntity<ClaimStatusDTO> returnClaimStatusOnUpdate(@RequestBody ClaimDetails claimDetails,  @RequestHeader(name = "Authorization", required = true)String token) throws InvalidTokenException
    {
        log.info("submitClaim EndPoint : Begin");
        
        // Checking the user validity
        //In this condition getsValidity function from the AuthClient of member service call particular 
        //function and check the validation status 
        //In validity function we are returning the data as validatingDTO (data transfer objects) by setting and getting the values
        if (!authClient.getsValidity(token).isValidStatus())  {
            
            throw new InvalidTokenException(msg);
        }
        
        log.info("Inside the submitClaim EndPoint : Ended");
        return new ResponseEntity<>( ClaimStatusAndDetails.fetchClaimDetails(claimDetails,token), HttpStatus.OK);

    }
    
     
}
