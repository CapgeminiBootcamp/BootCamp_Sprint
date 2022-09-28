package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.capg.entity.Customer;

public interface CustomerService {

	
	public Customer addCustomer(Customer customer);
	public Customer editCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Optional<Customer> findCustomerByID(int customerId);
	public int countBycustomerContactOrEmail(String contact,String email);
	public Customer findByEmailAndPassword(String email,String password);
	public Customer assignInsuranceToCustomer(int customerId, int insuranceId);
}
