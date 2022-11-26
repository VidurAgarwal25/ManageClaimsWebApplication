package com.policy.microservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.policy.microservice.model.Hospital;

@Repository
@Transactional
public interface HospitalRepo extends JpaRepository<Hospital,String>{
	/*
	 * @Query(value = "select status from Hospital h where h.hospitalId=?1") String
	 * getStatus(String id);
	 * 
	 * @Query(value = "select description from Hospital h where h.hospitalId=?1")
	 * String getDescription(String id);
	 */
}
