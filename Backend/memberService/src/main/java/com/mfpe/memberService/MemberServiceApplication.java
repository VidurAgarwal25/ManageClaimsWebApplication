package com.mfpe.memberService;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.mfpe.memberService")
public class MemberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}
	
	@Bean
	public Docket configureSwagger2(){
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.any())
					.apis(RequestHandlerSelectors.basePackage("com.mfpe.memberService"))		
					.build()
					.apiInfo(apiInfo());
				
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfo(
				"Claims Management",
				"Member Microservice",
				"1.0",
				"Aishwarya - Programmer Analyst",
				new Contact("Aishwarya", "https://www.linkedin.com/in/aishwarya-veldoj-3863a9190/","veldoj.aishwarya@cognizant.com"),
				"FSE", "https://hello.aishwarya.com",
				Collections.emptyList()
		);
	}
	

}