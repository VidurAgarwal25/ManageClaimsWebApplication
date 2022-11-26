package com.policy.microservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.repository.HospitalRepo;

@SpringBootTest
public class HospitalRepoTest {

	@MockBean
	HospitalRepo hospitalRepo;
	
	@Test
	@DisplayName("Checking if Policy Repo methods Are working or not")
	void testPolicyRepo() {
//		when(hospitalRepo.getStatus("H1")).thenReturn("Pending");
//		when(hospitalRepo.getDescription("H1")).thenReturn("Verified");
//		assertEquals("Pending", hospitalRepo.getStatus("H1"));
//		assertEquals("Verified", hospitalRepo.getDescription("H1"));
	}
}
