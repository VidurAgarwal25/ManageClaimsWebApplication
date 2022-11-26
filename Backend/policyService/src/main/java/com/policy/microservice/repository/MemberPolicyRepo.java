package com.policy.microservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.MemberPolicy;

@Repository
@Transactional
public interface MemberPolicyRepo extends JpaRepository<MemberPolicy,String>{
//	@Query(value = "select status from MemberPolicy m where m.memberPolicyId=?1")
//	String getStatus(String id);
//
//	@Query(value = "select description from MemberPolicy m where m.memberPolicyId=?1")
//	String getDescription(String id);

}
