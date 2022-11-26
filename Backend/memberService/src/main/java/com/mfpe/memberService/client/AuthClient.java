package com.mfpe.memberService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.memberService.dto.ValidatingDTO;



@FeignClient(name = "auth-client", url = "${Authorization.URL}")
public interface AuthClient {
	
	 // This function is called when it hits getsValidity() in any of the api call
	 // In this validity function we are returning the data as validatingDTO (data transfer objects) by setting and getting the values
	 // RequestHeader annotation binds request header values to method parameters.
	 @GetMapping(value = "/validate")
	      public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);

}
