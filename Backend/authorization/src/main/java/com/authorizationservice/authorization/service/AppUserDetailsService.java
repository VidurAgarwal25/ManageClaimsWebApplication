package com.authorizationservice.authorization.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorizationservice.authorization.model.AuthenticationRequest;

@Service
public interface AppUserDetailsService{
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
	//public boolean passwordVerifier(String password);
	public AuthenticationRequest getUser(String userName);
	public void saveUser(AuthenticationRequest user);
	public boolean passwordVerifier(String password, String ipassword);
	

}
