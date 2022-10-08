package com.capg.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.CalculateInsurance;
import com.capg.entity.Customer;
import com.capg.entity.EditCustomer;
import com.capg.entity.Insurance;
import com.capg.entity.TermInsuranceCalculator;
import com.capg.entity.UserLogin;

import com.capg.service.CustomerService;
import com.capg.service.InsuranceService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")

public class CustomerController {	
	@Autowired
	CustomerService customerService;
	 

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
    	return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
		
	}
	@PostMapping("/add-Customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {		
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
		
	}
	@PostMapping("/login")
	public ResponseEntity<Customer> checkLogin(@RequestBody UserLogin userLogin) {
		return new ResponseEntity<Customer>(customerService.findByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword()), HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")	
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.editCustomer(customer), HttpStatus.CREATED);
	}
	   
	
	@PutMapping("/{customerId}/puchaseInsurance/{insuranceId}")
    private ResponseEntity<Customer> assignInsuranceToCustomer(@PathVariable int customerId, @PathVariable int insuranceId) { 	
        return new ResponseEntity<Customer>(customerService.assignInsuranceToCustomer(customerId, insuranceId), HttpStatus.ACCEPTED);
    }
  
}