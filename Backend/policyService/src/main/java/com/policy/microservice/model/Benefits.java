package com.policy.microservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

//to generate the default no-args constructor for the annotated class
@NoArgsConstructor

@Entity
@Table(name="benefits")
public class Benefits {

	@Id
	@Column(name="BID")
	private String benefitId;
	
	@Column(name="Name")
	private String benefitName;

	public Benefits(String benefitId, String benefitName) {
		super();
		this.benefitId = benefitId;
		this.benefitName = benefitName;
	}
	
	//lazy denotes contents of the List are fetched only when you try to access them
	@JsonIgnore	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "benefits")
	private Set<Policy> policyBenefits = new HashSet<>();
	
	
}
