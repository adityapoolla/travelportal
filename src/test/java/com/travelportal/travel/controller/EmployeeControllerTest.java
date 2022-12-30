package com.travelportal.travel.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelportal.travel.entity.Employee;
import com.travelportal.travel.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest
{
    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeService employeeService;

    @Test
    public void testAddEmployee()
    {
        Employee employee = new Employee();
        employee.setEmail("abc@gmail.com");
        ResponseEntity<String> responseEntity = employeeController.saveEmployee(employee);

        assertTrue(responseEntity.getStatusCode().value() == 201);
    }

    @Test
    public void findUserByEmailTest() {
        Employee employee = new Employee();
        employee.setEmail("abc@gmail.com");
        employee.setPassword("password");
        when(employeeService.findUserByEmailandPassword(anyString(), anyString())).thenReturn(1L);
        ResponseEntity<String> responseEntity = employeeController.findUserByEmail(employee);
        assertTrue(responseEntity.getStatusCode().value() == 200);
    }

    @Test
    public void findUserByEmailTestNotFound() {
        Employee employee = new Employee();
        employee.setEmail("abc@gmail.com");
        employee.setPassword("password");
        when(employeeService.findUserByEmailandPassword(anyString(), anyString())).thenReturn(0L);
        ResponseEntity<String> responseEntity = employeeController.findUserByEmail(employee);
        assertTrue(responseEntity.getStatusCode().value() == 404);
    }

    @Test
    public void forgetPasswordTest() {
        Employee employee = new Employee();
        employee.setEmail("abc@gmail.com");
        employee.setPassword("password");
        when(employeeService.findUserByEmail(anyString())).thenReturn(1L);
        when(employeeService.updatePassword(anyString(), anyString())).thenReturn(1);
        ResponseEntity<String> responseEntity = employeeController.findUserBypassword(employee);
        assertTrue(responseEntity.getStatusCode().value() == 200);
    }

}
