package com.capg.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity @Data
public class Insurance {

	
	public Insurance(int insuranceId, String insuranceName, int sumAssurance, String preminiumAmount, int tenure) {
		this.insuranceId = insuranceId;
		this.insuranceName = insuranceName;
		this.sumAssurance = sumAssurance;
		this.preminiumAmount = preminiumAmount;
		this.tenture = tenure;
		
		
	}
	public Insurance() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int insuranceId;
	private String insuranceName;
	private long sumAssurance;
	private String preminiumAmount;
	private int tenture;
	
	@ManyToMany(mappedBy = "insurances")
	@JsonIgnore
	private List<Customer> customers;
}
