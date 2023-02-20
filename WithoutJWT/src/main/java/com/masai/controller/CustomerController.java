package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Customer;
import com.masai.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> registerCustomer(Customer cust){
		
		Customer regCustomer = cService.registerCustomer(cust);
		
		return new ResponseEntity<Customer>(regCustomer, HttpStatus.ACCEPTED);
	}
	
	
}
