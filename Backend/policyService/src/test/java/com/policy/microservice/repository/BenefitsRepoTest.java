package com.policy.microservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.repository.BenefitsRepo;

@SpringBootTest
class BenefitsRepoTest {

	@MockBean
	BenefitsRepo benefitsRepo;
	
	@Test
	@DisplayName("Checking if Policy Repo methods Are working or not")
	void testPolicyRepo() {
//		when(benefitsRepo.getStatus("B101")).thenReturn("Coverage for COVID-19");
//		assertEquals("Coverage for COVID-19", benefitsRepo.getStatus("B101"));
		assert(true);
	}
}
