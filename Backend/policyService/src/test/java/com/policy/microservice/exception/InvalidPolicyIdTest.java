package com.policy.microservice.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvalidPolicyIdTest {
	InvalidPolicyId invalidPolicyId = new InvalidPolicyId("Exception");
	@Test
	 void testComponentTyepNotFoundExceptionTest() {
		
		assertThat(invalidPolicyId).isNotNull();    
	}
	
}
