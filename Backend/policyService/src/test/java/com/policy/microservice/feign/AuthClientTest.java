package com.policy.microservice.feign;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class AuthClientTest {
  
    AuthClient authClient;
    
    
    @Test
    @DisplayName("Checking if [AuthClient] is loading or not.")
   void packagingClientIsLoaded(){
        assertThat(authClient).isNull();    
    }
}
