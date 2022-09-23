package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.entity.Customer;
import com.capg.repository.CustomerRepository;
@Repository
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer editCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {		
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerByID(int customerId) {		
		return customerRepository.findById(customerId);
	}

}
