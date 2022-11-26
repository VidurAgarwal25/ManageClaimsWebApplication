package com.policy.microservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.Benefits;

@Repository
@Transactional
public interface BenefitsRepo extends JpaRepository<Benefits,String>{
	
//	  @Query(value = "select benefitName from Benefits b where b.benefitsId=?1") 
//	  String getStatus(String id);
	 
}
