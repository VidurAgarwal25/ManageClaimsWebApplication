package com.mfpe.claimsmicroservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //Automatically scans the packages and sub packages where this is
@EnableFeignClients    //Allows intercommunication between microservices without writing detailed rest client code
@EnableSwagger2        //enables swagger2 for spring boot application
public class ClaimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimServiceApplication.class, args);
	}
	
	@Bean
	public Docket configureSwagger2(){
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.any())
					.apis(RequestHandlerSelectors.basePackage("com.mfpe.claimsmicroservice"))		
					.build()
					.apiInfo(apiInfo());
				
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfo(
				"Claim Management",
				"Claims Microservice",
				"1.0",
				"Vidur Programmer Analyst",
				new Contact("Vidur", "https://www.linkedin.com/in/vidur-agarwal-34307a189/","vidur.agarwal@cognizant.com"),
				"FSE", "https://hello.vidur.com",
				Collections.emptyList()
		);
	}

}
