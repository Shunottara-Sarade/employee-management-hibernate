package com.capg.service;

import com.capg.entity.Employee;

public interface EmployeeService {
	public Integer addEmployee(Employee employee);
	public Employee getEmployeeById(Integer id);
	public Integer deleteEmployee(Integer id);
	public Employee updateEmployee(Employee employee);

}
