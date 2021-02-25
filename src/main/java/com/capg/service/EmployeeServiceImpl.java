package com.capg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.EmployeeDao;
import com.capg.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Integer addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);


	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public Integer deleteEmployee(Integer id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

}
