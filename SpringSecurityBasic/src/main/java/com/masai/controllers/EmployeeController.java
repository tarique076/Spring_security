package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.beans.Employee;
import com.masai.dao.EmployeeDao;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp){
		emp.setPassword(passEncoder.encode(emp.getPassword()));
		
		Employee savedEmp = empDao.save(emp);
		
		return new ResponseEntity<Employee>(savedEmp, HttpStatus.OK);
	}
}
