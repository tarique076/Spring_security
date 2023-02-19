package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.exception.CustomerException;
import com.masai.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO cDao;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
