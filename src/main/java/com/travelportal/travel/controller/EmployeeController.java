package com.travelportal.travel.controller;


import com.travelportal.travel.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.travelportal.travel.constants.TravelConstants;
import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping("/api/travelportal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {
	//Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/saveData", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		//logger.info(null);

		try {
			employeeService.saveEmployee(employee);
			return new ResponseEntity<>(TravelConstants.USER_CREATED, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(TravelConstants.USER_CREATION_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path = "/logInUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> findUserByEmail(@RequestBody Employee employee) {
                
		    
		System.err.println("------------ " + employee.email);
		System.err.println("------------PWD  " + employee.password);

		Long count = employeeService.findUserByEmailandPassword(employee.email, employee.password);
		System.err.println(count);
		if (count == 0) {
			return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("USER  FOUND", HttpStatus.OK);

		}
	}

	@RequestMapping(path = "/forgotPassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> findUserBypassword(@RequestBody Employee employee) {

		try {
			if (StringUtils.isEmpty(employee.password)) {
				Long count = employeeService.findUserByEmail(employee.email);
				if (count == 0) {
					return new ResponseEntity<>(TravelConstants.FAILURE, HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(TravelConstants.SUCCESS, HttpStatus.OK);
				}
			} else {
				int status = employeeService.updatePassword(employee.password, employee.email);
				if (status == 0) {
					return new ResponseEntity<>(TravelConstants.FAILURE, HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(TravelConstants.OK, HttpStatus.OK);
				}
			
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TravelConstants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(path = "/resetPassword", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> findUser(@RequestBody Employee employee) {

		try {
			if (StringUtils.isEmpty(employee.password)) {
				Long count = employeeService.findUserByEmail(employee.email);
				if (count == 0) {
					return new ResponseEntity<>(TravelConstants.FAILURE, HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(TravelConstants.SUCCESS, HttpStatus.OK);
				}
			} else {
				int status = employeeService.updatePassword(employee.password, employee.email);
				if (status == 0) {
					return new ResponseEntity<>(TravelConstants.FAILURE, HttpStatus.NOT_FOUND);
				} else {
					return new ResponseEntity<>(TravelConstants.OK, HttpStatus.OK);
				}
			
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TravelConstants.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping(path = "/employee/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> updateUser(@RequestBody Employee employee, @PathVariable("id") Long id) {
		Employee empUpdated;
		try {
			empUpdated = employeeService.updateEmployee(employee, id);
		} catch(EmployeeNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(empUpdated, HttpStatus.OK);
	}
}
