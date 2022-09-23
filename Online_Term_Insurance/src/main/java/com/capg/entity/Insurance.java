package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class Insurance {

	
	@Id
	private int insuranceId;
	private String insuranceName;
	private long sumAssurance;
	private String preminiumType;
	private int tenture;
}
