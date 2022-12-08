package com.travelportal.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.service.EmployeeService;

@RestController
@RequestMapping("/api/travelportal")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/saveData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {

		try {
			employeeService.saveEmployee(employee);
			return new ResponseEntity<>("User created", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("User creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}

}
