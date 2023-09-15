package com.masai.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.beans.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findByUserName(String userName);	
}
