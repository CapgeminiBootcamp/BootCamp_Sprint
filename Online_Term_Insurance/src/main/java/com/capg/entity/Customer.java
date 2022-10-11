package com.capg.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity @Data @AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String cutomerName;
	private String customeraddress;
	private int customerAge;
	private long customerSalary;
	private String customerContact;
	private String customerGender;
	private String customerFamilyMembers;
	private String email ;
	private String password;
	
	public Customer(int i, String string, String string2, int j, int k, String string3, String string4, String string5,
		  String string6, String string7) {
		  customerId= i;
		  cutomerName = string;
		  customeraddress = string2;
		  customerAge = j;
		  customerSalary = k;
		  customerContact = string3;
		  customerGender = string4;
		  customerFamilyMembers = string5;
		  email = string6;
		  password = string7;
		
	}
	public Customer() {
		
	}
	
	

	



	@ManyToMany
	@JoinTable(name = "insurance_customer", joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId"), inverseJoinColumns = @JoinColumn(name = "insuranceId", referencedColumnName = "insuranceId"))
	private List<Insurance> insurances;

}               
