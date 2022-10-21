package com.zensar.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);
	
}
