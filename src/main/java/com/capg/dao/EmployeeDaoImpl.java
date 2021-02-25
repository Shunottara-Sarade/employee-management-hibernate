package com.capg.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		return employee.getId();
	}

	@Override
	public Employee getEmployeeById(Integer id){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee employee=session.get(Employee.class,id);
		employee.setFirstName("yami");
		session.getTransaction().commit();
		session.close();
		return employee;

	}

	@Override
	public Integer deleteEmployee(Integer id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee employee=session.find(Employee.class, id);
		session.remove(employee);
		session.getTransaction().commit();
		session.close();
		return employee.getId();

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee updateEmployee=(Employee) session.merge(employee);
		session.getTransaction().commit();
		session.close();
		return updateEmployee;
	}



}
