package com.authorizationservice.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AuthorizationApplication implements CommandLineRunner{
	
	@Autowired
	AuthRequestRepo authRequestRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}
	
	//Creating the credentials of the users
	@Override
	public void run(String... args) throws Exception{
		AuthenticationRequest user1 = new AuthenticationRequest("kaustubh","kaustubh01");
		AuthenticationRequest user2 = new AuthenticationRequest("swapnil","swapnil01");
		AuthenticationRequest user3 = new AuthenticationRequest("vidur","vidur01");
		AuthenticationRequest user4 = new AuthenticationRequest("yuvraj","yuvraj01");
		AuthenticationRequest user5 = new AuthenticationRequest("aishwarya","aishwarya01");
		
		//Loading the credentials into database using JPA Repository
		authRequestRepo.save(user1);
		authRequestRepo.save(user2);
		authRequestRepo.save(user3);
		authRequestRepo.save(user4);
		authRequestRepo.save(user5);
	}

}