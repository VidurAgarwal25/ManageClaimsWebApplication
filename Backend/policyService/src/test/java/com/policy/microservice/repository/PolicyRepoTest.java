package com.policy.microservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.repository.PolicyRepo;

@SpringBootTest
public class PolicyRepoTest {

	@MockBean
	PolicyRepo policyRepo;
	
	@Test
	@DisplayName("Checking if Policy Repo methods Are working or not")
	void testPolicyRepo() {
//		when(policyRepo.getStatus("P1001")).thenReturn("Pending");
//		when(policyRepo.getDescription("P1001")).thenReturn("Verified");
//		assertEquals("Pending", policyRepo.getStatus("P1001"));
//		assertEquals("Verified", policyRepo.getDescription("P1001"));
	}
}
