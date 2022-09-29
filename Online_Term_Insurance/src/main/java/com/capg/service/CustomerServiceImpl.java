package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capg.entity.Customer;
import com.capg.entity.Insurance;
import com.capg.entity.TermInsuranceCalculator;
import com.capg.exception.CustomersEmptyException;
import com.capg.exception.EmailOrPasswordException;
import com.capg.exception.EmptyFieldException;
import com.capg.exception.EnterValidDetailsException;
import com.capg.exception.InsuranceEmptyException;
import com.capg.repository.CustomerRepository;

@Repository
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	InsuranceService insuranceService;
	
	@Override
	public Customer addCustomer(Customer customer) {
		if(customer.getCustomerId()<0)
			throw new EnterValidDetailsException("Please Enter valid customerId");
		String email = customer.getEmail().trim();
		 String customerContact = customer.getCustomerContact();
	     String password =  customer.getPassword();
	     
	     String emailPattern="^[A-Za-z0-9._%+-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";
	     String mobilePattern="(^$|[6-9][0-9]{9})";
	    // String passwordPattern = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&-])(?=\\S+$).{8, 20}$"; 
	     
	    
	     //check password 
	     
	     boolean a;//validations lagane h 

	     if(email.equals("") || customerContact.equals("")) {
	         throw new EmptyFieldException("Fields can not be empty please insert ur email and password");	         
	     }else if(!customer.getEmail().matches(emailPattern)) {	        
	         throw new EmptyFieldException("Invalid email");
	     }
	     else if(!customer.getCustomerContact().matches(mobilePattern)) {	       
	         throw new EmptyFieldException("Invalid contact number");
	     }
	     else if(customer.getPassword() == "" || customer.getPassword().length() <8 ) {
	         throw new EmptyFieldException("Length of Password must be atleast 8 ");
	     }
	     else {
	         int info = customerRepository.countBycustomerContactOrEmail(customer.getCustomerContact(), customer.getEmail());

	         if(info > 0) {	             
	             throw new EmptyFieldException("Please Login to continue");
         }
	     }
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer editCustomer(Customer customer) {		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {	
		List<Customer> list = customerRepository.findAll();
		if (list.isEmpty())
			throw new CustomersEmptyException("No Customer Data is present right now");
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerByID(int customerId) {		
		return customerRepository.findById(customerId);
	}

	@Override
	public int countBycustomerContactOrEmail(String contact, String email) {	
		return customerRepository.countBycustomerContactOrEmail(contact, email);
	}

	@Override
	public Customer findByEmailAndPassword(String email, String password) {
		Customer result=customerRepository.findByEmailAndPassword(email,password);
		if(result==null)
		   throw new EmailOrPasswordException("error in ur passsword or email");
		return customerRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public Customer assignInsuranceToCustomer(int customerId, int insuranceId) {
		Customer customer=null;
	   if(customerId<0 || insuranceId<0) {	    		
	    		throw new EnterValidDetailsException("Either customerId Or insuranceId Is Invalid Please Enter Correct ");
	    	}
	   else if(!insuranceService.findInsuranceByID(insuranceId).isPresent() || !findCustomerByID(customerId).isPresent()) {
		   throw new InsuranceEmptyException("Either InsuranceId "+insuranceId+" Or customerId "+customerId+" Not present in database please Enter Correct Id");		   
	   }
	   else {
	    	customer = findCustomerByID(customerId).get();
	        Insurance insurance = insuranceService.findInsuranceByID(insuranceId).get();
	        customer.getInsurances().add(insurance);
	        customerRepository.save(customer);
	     }
	   return customer;

	}
	
	@Override
	public String calculateInsurance(TermInsuranceCalculator termInsuranceCalculator) {
		
		Long EstimateValue = (long) 0;
		
		if(termInsuranceCalculator.getSalary() > 100000 && termInsuranceCalculator.getSalary() < 500000) {
			
			EstimateValue = (termInsuranceCalculator.getSalary() * 15);
			return "Your final Estimated Value is" + EstimateValue;
			
		}else if(termInsuranceCalculator.getSalary() > 500000 && termInsuranceCalculator.getSalary() < 1000000) {
			
			EstimateValue = (termInsuranceCalculator.getSalary() * 18);
			return "Your final Estimated Value is" + EstimateValue;
			
		}else if(termInsuranceCalculator.getSalary() > 1000000) {
			
			EstimateValue = (termInsuranceCalculator.getSalary() * 20);
			return "Your final Estimated Value is" + EstimateValue;
		}else
			
			return "Sorry! you are not eligible for any Insurance";
	}
	
	
	
	
}
