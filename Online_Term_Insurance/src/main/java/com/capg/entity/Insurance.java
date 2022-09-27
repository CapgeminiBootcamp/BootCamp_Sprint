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

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuranceId;
	private String insuranceName;
	private long sumAssurance;
	private String preminiumType;
	private int tenture;
	
	@ManyToMany(mappedBy = "insurances")
	@JsonIgnore
	private List<Customer> customers;
}
