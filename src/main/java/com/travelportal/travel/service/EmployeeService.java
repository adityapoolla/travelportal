package com.travelportal.travel.service;

import java.util.List;
import java.util.Optional;

import com.travelportal.travel.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Long findUserByEmailandPassword(String email, String password);

	Long findUserByEmail(String email);

	int updatePassword(String password, String email);
	
	List<Employee> getAllEmployees();

	void updateEmployee(Employee employee, Long id);
}
