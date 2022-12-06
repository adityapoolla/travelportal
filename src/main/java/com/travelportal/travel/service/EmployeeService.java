package com.travelportal.travel.service;
import java.util.List;

import com.travelportal.travel.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

    Employee findUserById(Long id);

    List<Employee> getAllEmployees();
    
    
	
}
