package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Customer {
	@Id
	private int customerId;
	private String Name;
	private String contantNo;
	private String email;
	
	

}
