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

import lombok.Data;

@Entity @Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@ManyToMany
	@JoinTable(name = "insurance_customer", joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId"), inverseJoinColumns = @JoinColumn(name = "insuranceId", referencedColumnName = "insuranceId"))
	private List<Insurance> insurances;

}
