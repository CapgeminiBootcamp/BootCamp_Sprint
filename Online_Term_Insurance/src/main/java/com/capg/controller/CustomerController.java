package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.exception.CustomerAlreadyPresentException;
import com.capg.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public List<Customer> getAllCustomers(){		
		return customerService.getCustomers();
		
	}
	
	@PostMapping("/add-Customer")
	public Customer saveCustomer(@RequestBody Customer customer) {	
		if(customerService.findCustomerByID(customer.getCustomerId()).isPresent())
			throw new CustomerAlreadyPresentException("Entered id"+customer.getCustomerId()+"is already Present Please Enter another id");
		customerService.addCustomer(customer);	
		return customer;
		
	}
	
	@PutMapping("/edit-Customer")
	public Customer editCustomer(@RequestBody Customer customer) {
		customerService.editCustomer(customer);
		return customer;
	}
}
