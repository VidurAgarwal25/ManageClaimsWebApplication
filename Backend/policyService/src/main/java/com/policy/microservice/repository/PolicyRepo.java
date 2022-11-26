package com.policy.microservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.Policy;

@Repository
@Transactional
public interface PolicyRepo extends JpaRepository<Policy,String>{
//	@Query(value = "select status from Policy p where p.policyId=?1")
//	String getStatus(String id);
//
//	@Query(value = "select description from Policy p where p.policyId=?1")
//	String getDescription(String id);

}
