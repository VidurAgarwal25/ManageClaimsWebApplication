package com.mfpe.claimsmicroservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Hospital {

	private @Getter @Setter String hospitalId;
	
	
	private @Getter @Setter String name;

	private @Getter @Setter String location;
	

	public Hospital(String hospitalId, String name, String location) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.location = location;
	}
	
}
