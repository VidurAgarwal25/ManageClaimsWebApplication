package com.mfpe.claimsmicroservice.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	private Date date;
	private String message;
	private String requestURL;
}
