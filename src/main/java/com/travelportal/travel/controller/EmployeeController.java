package com.travelportal.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.service.EmployeeService;

@RestController
@RequestMapping("/api/travelportal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

	@PostMapping(path = "/logInUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> findUserByEmail(@RequestBody Employee employee) {

		System.err.println("------------ " + employee.email);
		Long count = employeeService.findUserByEmailandPassword(employee.email, employee.password);
		System.err.println(count);
		if (count == 0) {
			return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("USER  FOUND", HttpStatus.OK);

		}
	}

	@RequestMapping(path = "/resetPassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> findUserBypassword(@RequestBody Employee employee) {

		try {
			if (StringUtils.isEmpty(employee.password)) {
				Long count = employeeService.findUserByEmail(employee.email);
				if (count == 0) {
					return new ResponseEntity<>("FAILURE", HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
				}
			} else {
			
				Long counts = employeeService.update(employee.email, employee.password);

				if (counts == 0) {
					return new ResponseEntity<>("FAILURE", HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>("DETAILS UPDATED SUCCESSFULLY", HttpStatus.OK);
				}

				// return new ResponseEntity<>("FAILURE", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
