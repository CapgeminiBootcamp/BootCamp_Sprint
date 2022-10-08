package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.entity.Insurance;
import com.capg.service.CustomerService;
import com.capg.service.InsuranceService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/v1/admin/")
public class AdminController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	InsuranceService insuranceService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> adminGetAllCustomers(){
    	return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
		
	}
	
	@GetMapping("/getById/{customerId}")
	public ResponseEntity<Customer> adminGetByCustomerId(@PathVariable int customerId){
    	return new ResponseEntity<Customer>(customerService.findCustomerByID(customerId), HttpStatus.OK);
		
	}
	
	@PostMapping("/add-Customer")
	public ResponseEntity<Customer> adminSaveCustomer(@RequestBody Customer customer) {		
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete-Customer/{customerId}")
	public ResponseEntity<String> adminDeleteCustomer(@PathVariable int customerId) {		
		return new ResponseEntity<String>(customerService.deleteCustomer(customerId), HttpStatus.CREATED);
		
	}
	@PostMapping("/add-Insurance")
	public ResponseEntity<Insurance> adminSaveInsurance(@RequestBody Insurance insurance) {		
		return new ResponseEntity<Insurance>(insuranceService.addInsurance(insurance), HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/delete-Insurance/{insuranceId}")
	public ResponseEntity<Insurance> adminDeleteInsurance(@PathVariable int insuranceId) {		
		return new ResponseEntity<Insurance>(insuranceService.deleteInsurance(insuranceId), HttpStatus.CREATED);
		
	}
}
