package com.mfpe.claimsmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.claimsmicroservice.dto.ValidatingDTO;



@FeignClient(name = "auth-client", url = "${Authorization.URL}") //authorization.url has the complete url saved in application file
public interface AuthClient {
	
	 @GetMapping(value = "/validate")
	 //RequestHeader binds request header values to method parameters
	 //the authorization header is always required and the value of this header will be token
     public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);

}
