package com.mfpe.claimsmicroservice.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.claimsmicroservice.dto.BenefitsDTO;
import com.mfpe.claimsmicroservice.dto.ClaimAmountDTO;
import com.mfpe.claimsmicroservice.dto.ProviderDTO;


@FeignClient(name = "policy-service", url = "${Policy.URL}")
public interface PolicyClient {
	//HTTP RESPONSE FROM ProviderDTO ->list of hospitals
	@GetMapping(path="/getChainOfProviders/{policyId}")
	public ResponseEntity<ProviderDTO> getChainOfProviders(@PathVariable("policyId") String policyId,@RequestHeader(name = "Authorization", required = true) String token);
	
	//HTTP RESPONSE FROM BenefitDTO -> list of benefits
	@GetMapping(path="/getEligibleBenefits/{policyId}/{memberId}")
	public ResponseEntity<BenefitsDTO> getEligibleBenefits(@PathVariable("policyId") String policyId,@PathVariable("memberId") String memberId,@RequestHeader(name = "Authorization", required = true) String token);
	
	//HTTP RESPONSE FROM ClaimAmountDTO -> claimed amount
	@GetMapping(path="/getEligibleClaimAmount/{policyId}/{memberId}")
	public ResponseEntity<ClaimAmountDTO> getEligibleAmount(@PathVariable("policyId") String policyId,@PathVariable("memberId") String memberId,@RequestHeader(name = "Authorization", required = true) String token);
}
