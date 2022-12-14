package com.policy.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="member_policy")
public class MemberPolicy {
	
	@Id
	@Column(name="MID")
	private @Getter @Setter String memberId;
	
	@Column(name="PID")
	private @Getter @Setter String policyId;
	
	@Column(name="tenure")
	private @Getter @Setter int tenure;
	
	@Column(name="premium_last_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private @Getter @Setter String premiumLastDate;
	
	@Column(name="subscription_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private @Getter @Setter String subscriptionDate;
}
