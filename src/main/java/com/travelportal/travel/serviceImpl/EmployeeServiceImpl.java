package com.travelportal.travel.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.repository.EmployeeRepository;
import com.travelportal.travel.service.EmployeeService;

@Service


public class EmployeeServiceImpl implements EmployeeService{
 
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findUserByEmail(String email) {
		Optional<Employee> findByEmail = employeeRepository.findById(email);
		return findByEmail.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}


	
}

