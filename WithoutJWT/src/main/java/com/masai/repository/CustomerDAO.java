package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
