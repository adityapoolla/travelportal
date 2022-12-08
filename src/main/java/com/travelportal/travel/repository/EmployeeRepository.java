package com.travelportal.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.travelportal.travel.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

}

