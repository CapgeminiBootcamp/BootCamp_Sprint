package com.capg.service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.capg.entity.Customer;
import com.capg.entity.EditCustomer;
import com.capg.entity.Insurance;
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
	public Customer editCustomer(EditCustomer editCustomer) {	
//		EditCustomer result=new EditCustomer(customer.getCutomerName(),customer.getCustomeraddress(),customer.getCustomerAge(),customer.getCustomerSalary(),
//				customer.getCustomerContact(),customer.getCustomerGender(),customer.getCustomerFamilyMembers());
//		Optional<Customer> customer=customerRepository.findById(editCustomer.getCustomerId());		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Object email=auth.getCredentials();)

		return null;
	}

	@Override
	public List<Customer> getCustomers() {	
		List<Customer> list = customerRepository.findAll();
		if (list.isEmpty())
			throw new CustomersEmptyException("No Customer Data is present right now");
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerByID(int customerId) {
		Optional<Customer> result=customerRepository.findById(customerId);
		if(result==null)
			throw new CustomersEmptyException("");
		return result.get();
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
	   else if(!insuranceService.findInsuranceByID(insuranceId).isPresent() || !(findCustomerByID(customerId)!=null)) {
		   throw new InsuranceEmptyException("Either InsuranceId "+insuranceId+" Or customerId "+customerId+" Not present in database please Enter Correct Id");		   
	   }
	   else {
	    	customer = findCustomerByID(customerId);
	        Insurance insurance = insuranceService.findInsuranceByID(insuranceId).get();
	        customer.getInsurances().add(insurance);
	        customerRepository.save(customer);
	     }
	   return customer;

	}
	
	@Override
	public String calculateInsurance(int id) {	
		Customer customer=customerRepository.findById(id).get();
		Long EstimateValue = 0l;		
		if(customer.getCustomerSalary() > 100000 && customer.getCustomerSalary() < 500000) 		
			EstimateValue = (customer.getCustomerSalary() * 15);				
		else if(customer.getCustomerSalary() > 500000 && customer.getCustomerSalary() < 1000000) 			
			EstimateValue = (customer.getCustomerSalary() * 18);						
		else if(customer.getCustomerSalary()> 1000000) 			
			EstimateValue = customer.getCustomerSalary() * 20;				
		if(EstimateValue==0l)
			throw new InsuranceEmptyException("You cant ");
		return "Your final Estimated Value is" + EstimateValue;
			
	}

	@Override
	public String deleteCustomer(int customerId) {
		Optional<Customer> result=customerRepository.findById(customerId);
		if(result==null)
			throw new CustomersEmptyException("Customer not present in database");
	    customerRepository.deleteById(customerId);
	    return "Deleted Successfully";
	}
	
	
//	"Your final Estimated Value is" + EstimateValue
	
}
