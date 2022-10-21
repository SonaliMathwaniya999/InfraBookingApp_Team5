package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Employee;
import com.zensar.repositry.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	
	 
	
	public Employee findByEmail(String email)
	{
		return this.dao.findByEmail(email);
		
	}




	public Employee addEmployee(Employee employee) {
	 	 
		return this.dao.save(employee);
	}
	
}
