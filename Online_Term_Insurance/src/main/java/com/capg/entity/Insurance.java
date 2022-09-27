package com.capg.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity @Data
public class Insurance {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insuranceId;
	private String insuranceName;
	private long sumAssurance;
	private String preminiumType;
	private int tenture;
	
	@ManyToMany
	private List<Customer> customers;
}
