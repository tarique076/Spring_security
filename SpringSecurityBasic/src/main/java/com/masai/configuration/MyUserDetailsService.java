package com.masai.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.beans.Employee;
import com.masai.beans.MyUserDetails;
import com.masai.dao.EmployeeDao;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> optEmp = empDao.findByUserName(username);
		
		if(optEmp.isPresent()) {
			return new MyUserDetails(optEmp.get());
		}else {
			throw new UsernameNotFoundException("User not found");
		}
	}

}
