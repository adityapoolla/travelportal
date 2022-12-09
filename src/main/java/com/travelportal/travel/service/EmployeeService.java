package com.travelportal.travel.service;
import java.util.List;

import com.travelportal.travel.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Long findUserByEmail(String Email);

    List<Employee> getAllEmployees();
    
    
	
}
