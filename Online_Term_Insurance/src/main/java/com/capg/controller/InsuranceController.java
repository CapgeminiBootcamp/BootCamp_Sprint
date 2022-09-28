package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.entity.Insurance;
import com.capg.exception.CustomersEmptyException;
import com.capg.exception.EnterValidDetailsException;
import com.capg.exception.InsuranceEmptyException;
import com.capg.service.InsuranceService;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

	
	

	@Autowired
	InsuranceService insuranceService;	
	@GetMapping("/insurances")
	public ResponseEntity<List<Insurance>> getAllInsurances(){
    	return new ResponseEntity<List<Insurance>>(insuranceService.getInsurances(), HttpStatus.OK);	
	}
	
	@PostMapping("/insurance")
	public ResponseEntity<Insurance> addInsurance(@RequestBody Insurance insurance) {
		return new ResponseEntity<Insurance>(insuranceService.addInsurance(insurance), HttpStatus.CREATED);
	}
	
	@PutMapping("/insurance")
	public ResponseEntity<Insurance> editCustomer(@RequestBody Insurance insurance) {
		return new ResponseEntity<Insurance>(insuranceService.addInsurance(insurance), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{insuranceId}")
	public ResponseEntity<Insurance> deleteCustomer(@PathVariable int insuranceId) {
		return new ResponseEntity<Insurance>(insuranceService.deleteInsurance(insuranceId), HttpStatus.CREATED);
	}
}
