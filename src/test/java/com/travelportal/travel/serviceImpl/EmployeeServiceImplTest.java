package com.travelportal.travel.serviceImpl;

import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.exception.EmployeeNotFoundException;
import com.travelportal.travel.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository repository;


    @Test
    public void saveEmployeeTest() {
        Employee empExpected = buildEmployee();
        when(repository.save(any(Employee.class))).thenReturn(empExpected);
        Employee emp = employeeService.saveEmployee(empExpected);
        assertTrue(empExpected.equals(emp));
        assertTrue(empExpected.getEmail().equals(emp.getEmail()));
    }

    @Test
    public void getAllEmployeesTest() {
        List<Employee> list = new ArrayList<>();
        list.add(buildEmployee());
        when(repository.findAll()).thenReturn(list);
        List<Employee> actual = employeeService.getAllEmployees();
        assertTrue(list.size() == actual.size());
    }

    @Test
    public void findUserByEmailAndPasswordTest() {
        when(repository.findUserByEmailandPassword(anyString(), anyString())).thenReturn(2L);
        Long emp = employeeService.findUserByEmailandPassword(anyString(), anyString());
        assertTrue(emp == 2L);
    }

    @Test
    public void findUserByEmailTest() {
        when(repository.findUserByEmail(anyString())).thenReturn(2L);
        Long emp = employeeService.findUserByEmail(anyString());
        assertTrue(emp == 2L);
    }

    @Test
    public void updatePasswordTest() {
        when(repository.updatePassword(anyString(), anyString())).thenReturn(1);
        int count = employeeService.updatePassword(anyString(), anyString());
        assertTrue(count == 1);
    }

    @Test
    public void updateEmployee() {
        Employee emp = buildEmployee();
        when(repository.findById(anyLong())).thenReturn(Optional.of(buildEmployeeDb()));
        when(repository.save(any(Employee.class))).thenReturn(emp);
        employeeService.updateEmployee(emp, 1L);
    }

    @Test
    public void updateOnlyMobileNumber() {
        Employee emp = buildEmployee();
        when(repository.findById(anyLong())).thenReturn(Optional.of(buildEmployeeDb()));
        when(repository.save(any(Employee.class))).thenReturn(emp);
        Employee empInp = new Employee();
        empInp.setMobileNumber("129831923");
        Employee employee = employeeService.updateEmployee(empInp, 1L);
        assertTrue(employee.getAddress().equals(emp.getAddress()));
    }

    @Test(expected = EmployeeNotFoundException.class)
    public void updateNotFoundException() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        employeeService.updateEmployee(any(Employee.class), 1L);
    }

    private Employee buildEmployee() {
        Employee employee = new Employee();
        employee.setMobileNumber("121212121");
        employee.setAddress("some address");
        employee.setLinkedIn("linkedInId");
        employee.setFirstName("first name");
        employee.setLastName("lastname");
        employee.setEmail("email@email.com");
        return employee;
    }

    private Employee buildEmployeeDb() {
        Employee employee = new Employee();
        employee.setEmail("email@email.com");
        return employee;
    }
}
