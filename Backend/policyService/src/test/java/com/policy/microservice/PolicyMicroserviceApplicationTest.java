
  package com.policy.microservice;
  
  import static org.assertj.core.api.Assertions.assertThat; 
  import static org.junit.jupiter.api.Assertions.assertTrue;
  
  import org.junit.jupiter.api.Disabled; 
  import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
  
  @SpringBootTest
  class PolicyMicroserviceApplicationTest {
  
	  @Autowired
	 PolicyMicroserviceApplication policyMicroserviceApplication;
  
  
  @Test 
  void contextLoads() { 
	  assertTrue(true); 
	  }
  
		
  @Test 
  @Disabled
  void testComponentProcessingMicroserviceApplication() {
		 assertThat(policyMicroserviceApplication).isNull(); 
		 }
		 
  }
  
  
 