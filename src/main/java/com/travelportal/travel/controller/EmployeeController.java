package com.travelportal.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/travelportal")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path= "/saveData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		
		System.err.println(employee.toString());
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return  new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
		
	}
	
	
	
}
