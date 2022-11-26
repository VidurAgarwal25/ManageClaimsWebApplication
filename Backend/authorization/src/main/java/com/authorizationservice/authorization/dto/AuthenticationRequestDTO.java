package com.authorizationservice.authorization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor 
public class AuthenticationRequestDTO {
	private @Getter @Setter String username;
	private  @Getter @Setter String password;
}
