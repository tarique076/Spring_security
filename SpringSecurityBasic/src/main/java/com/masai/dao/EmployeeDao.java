package com.masai.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.beans.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findByUserName(String userName);	
}
