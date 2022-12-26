package com.travelportal.travel.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.travelportal.travel.constants.TravelConstants;
import com.travelportal.travel.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.repository.EmployeeRepository;
import com.travelportal.travel.service.EmployeeService;
import org.springframework.util.StringUtils;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Long findUserByEmailandPassword(String email, String password) {
		return employeeRepository.findUserByEmailandPassword(email, password);
	}

	@Override
	public Long findUserByEmail(String email) {
		return employeeRepository.findUserByEmail(email);
	}

	@Override
	public int updatePassword(String password, String email) {
		return employeeRepository.updatePassword(password,email);
	}


	@Override
	public void updateEmployee(Employee employee, Long id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		if(!employeeOptional.isPresent()) {
			throw new EmployeeNotFoundException(TravelConstants.NOT_FOUND);
		}
		Employee employeeDb = employeeOptional.get();
		if(!StringUtils.isEmpty(employee.getFirstName())) {
			employeeDb.setFirstName(employee.getFirstName());
		}
		if(!StringUtils.isEmpty(employee.getLastName())) {
			employeeDb.setLastName(employee.getLastName());
		}
		if(!StringUtils.isEmpty(employee.getAddress())) {
			employeeDb.setAddress(employee.getAddress());
		}
		if(!StringUtils.isEmpty(employee.getLinkedIn())) {
			employeeDb.setLinkedIn(employee.getLinkedIn());
		}
		if(!StringUtils.isEmpty(employee.getMobileNumber())) {
			employeeDb.setMobileNumber(employee.getMobileNumber());
		}
		employeeRepository.save(employeeDb);
	}


}
