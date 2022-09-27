package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public int countBycustomerContactOrEmail(String contact, String email);
	public Customer findByEmailAndPassword(String email,String password);
}
