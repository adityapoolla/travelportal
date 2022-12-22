package com.travelportal.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travelportal.travel.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT count(*) from Employee where email =:email and password =:password")
	public Long findUserByEmailandPassword(String email, String password);

	@Query("SELECT count(*) from Employee where email =:email")
	public Long findUserByEmail(String email);
	
	@Query("UPDATE Employee set password=:password where email=:email")
	public Long update(String email, String password);
}

