package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Employee;
import com.capg.service.EmployeeService;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {
	@Autowired(required = false)
	private EmployeeService employeeService;

	@ApiOperation(value="Get employee by Id",tags="get-employee-by-id",response = Employee.class,
			consumes="id",httpMethod = "GET")
	@GetMapping("/{id}")
	public  ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee= employeeService.getEmployeeById(id);
		log.info("data is"+ employee);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}

	@ApiOperation(value="add employee",tags="add-employee")
	@PostMapping(value="/create")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee.getFirstName() + "added to database";
	}

	@ApiOperation(value="delete employee",tags="delete-employee-by-id")
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Integer id) 
	{
		employeeService.deleteEmployee(id);
		return id + "deleted from database";
	}

	@ApiOperation(value="update employee",tags="update-employee")
	@PutMapping("/")
	public ResponseEntity<Employee> updateCustomer(@RequestBody Employee employee){
		Employee updateEmployee= employeeService.updateEmployee(employee);
		log.info("Employee: "+employee.getFirstName()+ " updated");
		return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	}




}
