package com.travelportal.travel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travelportal.travel.entity.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT count(*) from Employee where email =:email and password =:password")
	public Long findUserByEmailandPassword(String email, String password);

	@Query("SELECT count(*) from Employee where email =:email")
	public Long findUserByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE Employee set password=:password where email=:email")
	public int updatePassword(String password, String email);

}

