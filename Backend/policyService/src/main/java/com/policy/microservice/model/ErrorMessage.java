package com.policy.microservice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	
	  private @Getter @Setter int statusCode;
	  private @Getter @Setter Date timestamp;
	  private @Getter @Setter String message;
	  private @Getter @Setter String description;

}
