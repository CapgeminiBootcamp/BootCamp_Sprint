package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.capg.entity.Customer;
import com.capg.entity.EditCustomer;
import com.capg.entity.TermInsuranceCalculator;

public interface CustomerService {

	
	public Customer addCustomer(Customer customer);
	public Customer editCustomer(EditCustomer customer);
	public List<Customer> getCustomers();
	public Customer findCustomerByID(int customerId);
	public int countBycustomerContactOrEmail(String contact,String email);
	public Customer findByEmailAndPassword(String email,String password);
	public Customer assignInsuranceToCustomer(int customerId, int insuranceId);
	String calculateInsurance(int id);
	public String deleteCustomer(int customerId);
}
