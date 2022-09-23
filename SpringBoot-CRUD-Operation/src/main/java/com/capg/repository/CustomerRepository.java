package com.capg.repository;

import org.springframework.data.repository.CrudRepository;

import com.capg.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	 
	
}

