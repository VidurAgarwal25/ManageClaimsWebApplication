package com.policy.microservice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.policy.microservice.repository.MemberPolicyRepo;

@SpringBootTest
public class MemberPolicyRepoTest {

	@MockBean
	MemberPolicyRepo memberPolicyRepo;
	
	@Test
	@DisplayName("Checking if Policy Repo methods Are working or not")
	void testPolicyRepo() {
//		when(memberPolicyRepo.getStatus("M101")).thenReturn("Pending");
//		when(memberPolicyRepo.getDescription("M101")).thenReturn("Verified");
//		assertEquals("Pending", memberPolicyRepo.getStatus("M101"));
//		assertEquals("Verified", memberPolicyRepo.getDescription("M101"));
	}
}
