package com.capg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Customer;
import com.capg.entity.Insurance;
import com.capg.entity.UserLogin;
import com.capg.exception.CustomerAlreadyPresentException;
import com.capg.exception.CustomersEmptyException;
import com.capg.exception.EmailOrPasswordException;
import com.capg.exception.EmptyFieldException;
import com.capg.exception.EnterValidDetailsException;
import com.capg.service.CustomerService;
import com.capg.service.InsuranceService;
@RestController
@RequestMapping("api/v1/")
public class CustomerController {	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	InsuranceService insuranceService;
	

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> list = customerService.getCustomers();
		if (list.isEmpty())
			throw new CustomersEmptyException("No Customer Data is present right now");
    	return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		
	}
	@PostMapping("/add-Customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
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
	         int info = customerService.countBycustomerContactOrEmail(customer.getCustomerContact(), customer.getEmail());

	         if(info > 0) {	             
	             throw new EmptyFieldException("Please Login to continue");
         }
//	             else {
//	             Customer inf = customerService.addCustomer(customer);
//	             str = "Entered"; 
//	             Map<String,String> map=new HashMap<String, String>();
//		     map.put("Status Code", "202");
//			     map.put("message", "Details Entered");
//			   	            
//	         }
	     }
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
		
	}
	@PostMapping("/login")
	public ResponseEntity<Customer> checkLogin(@RequestBody UserLogin userLogin) {
		Customer result=customerService.findByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword());
		if(result==null)
		   throw new EmailOrPasswordException("error in ur passsword or email");
		return new ResponseEntity<Customer>(customerService.addCustomer(result), HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{customerId}/puchaseInsurance/{insuranceId}")
    private ResponseEntity<Customer> assignInsuranceToCustomer(@PathVariable int customerId, @PathVariable int insuranceId) {
    	
    	if(customerId<0 || insuranceId<0) {
    		
    		throw new EnterValidDetailsException("Either customerId Or insuranceId Is Invalid Please Enter Correct ");
    	}
    	else {
    		Customer customer = customerService.findCustomerByID(customerId).get();
        Insurance insurance = insuranceService.findInsuranceByID(insuranceId).get();
        customer.getInsurances().add(insurance);
        return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.ACCEPTED);
    }
 }  
}