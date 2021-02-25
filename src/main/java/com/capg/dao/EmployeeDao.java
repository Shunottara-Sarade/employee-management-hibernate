package com.capg.dao;

import com.capg.entity.Employee;


public interface EmployeeDao{
	public Integer addEmployee(Employee employee);
	public Employee getEmployeeById(Integer id) ;
	public Integer deleteEmployee(Integer id) ;
	public Employee updateEmployee(Employee employee);

}
