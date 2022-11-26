package com.mfpe.claimsmicroservice.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.claimsmicroservice.dto.ClaimStatusDTO;
import com.mfpe.claimsmicroservice.exceptions.InvalidClaimIdException;
import com.mfpe.claimsmicroservice.repository.ClaimRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClaimStatusService {

	@Autowired
	ClaimRepo claimRepo;
	
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(String claimId) throws InvalidClaimIdException {
			log.info("inside getClaimStatus in service ");
			ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO();
			//claimrepo is an interface extending jpa repository returning values of status and description for particular policyid
			String status = claimRepo.findByClaimId(claimId).getStatus();
			System.out.println(claimRepo.findById(claimId));
			String desc = claimRepo.findByClaimId(claimId).getStatus();
			if (status == null) {
				throw new InvalidClaimIdException("Invalid Claim ID");   //throwing an exception
			}
			claimStatusDTO.setClaimStatus(status);                      
			claimStatusDTO.setClaimDescription(desc);
			claimStatusDTO.setClaimId(claimId);
			log.info("inside the get Claim Status : ENDED");            //transmitting response of claim status and claim description
			return new ResponseEntity<>(claimStatusDTO, HttpStatus.OK);
	}

}
