package com.policy.microservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="policy")
@Getter
@Setter
@NoArgsConstructor
public class Policy{
	
	@Id
	@Column(name="PID")
	private @Getter @Setter String policyId;
	
	@Column(name="Policy_Type")
	private @Getter @Setter String policyType;
	
	@Column(name="Cap_Amount")
	private @Getter @Setter double sumInsured;
	
	@Column(name="Premium")
	private @Getter @Setter double premium;
	
	/*Cascade all means if a record in the parent table is changed, 
	then the corresponding records in the child table will automatically be changed.*/ 
	
	/*The joinColumn attribute will connect to the owner side of the relationship, 
	  and the inverseJoinColumn to the other side */
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="provider_policy", joinColumns= @JoinColumn(name="policyId"),
								  inverseJoinColumns= @JoinColumn(name="hospitalId"))
	private @Getter @Setter Set<Hospital> hospitals = new HashSet<>();
	
	@JsonIgnore	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="policy_benefits", joinColumns= @JoinColumn(name="policyId"),
					  inverseJoinColumns= @JoinColumn(name="benefitID"))
	private @Getter @Setter Set<Benefits> benefits = new HashSet<>();
	
	public Policy(String policyId, String policyType, double sumInsured, double premium) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.sumInsured = sumInsured;
		this.premium = premium;
	}
}