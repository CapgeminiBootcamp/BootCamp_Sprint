package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.entity.Customer;

public interface CustomerService {

	
	public Customer addCustomer(Customer customer);
	public Customer editCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Optional<Customer> findCustomerByID(int customerId);
}
