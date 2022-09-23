package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class Customer {
	
	@Id
	private int customerId;
	private String cutomerName;
	private String customeraddress;
	private int customerAge;
	private long customerSalary;
	private long customerContact;
	private String customerGender;
	private String customerFamilyMembers;

}
