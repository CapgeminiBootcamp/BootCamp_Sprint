package com.capg.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.exceptions.IdNotFoundException;
import com.capg.repository.CustomerRepository;

@RestController
public class CustomerController {	
	@Autowired
	private CustomerRepository repo;
	
	@GetMapping("/getCustomer")
	public Iterable<Customer> getCustomers() {
		return repo.findAll();
	}
	@GetMapping("/getCustomer/{custid}")
	public Optional<Customer> getCustomerById(@PathVariable int custid) {
		
		Optional<Customer> customer=repo.findById(custid);
		
		if(!customer.isPresent())
			throw new IdNotFoundException("not found id");
		return customer;
	}
	
	@PostMapping("/addCustomer")
	  public Customer addCustomer(@RequestBody Customer customer) {
		repo.save(customer);
		return customer;
	}
}
