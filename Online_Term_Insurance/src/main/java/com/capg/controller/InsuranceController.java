package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Insurance> list = insuranceService.getInsurances();
		if (list.isEmpty())
			throw new InsuranceEmptyException("No Insurance Data is present right now");
    	return new ResponseEntity<List<Insurance>>(list, HttpStatus.OK);	
	}
	
	@PutMapping("/insurance")
	public ResponseEntity<Insurance> editCustomer(@Validated @RequestBody Insurance insurance) {
		if(insurance.getInsuranceId()<0)
			throw new EnterValidDetailsException("Please Enter valid insuranceId");
		return new ResponseEntity<Insurance>(insuranceService.addInsurance(insurance), HttpStatus.CREATED);
	}
}
