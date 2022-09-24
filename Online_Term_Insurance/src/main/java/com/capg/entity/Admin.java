package com.capg.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity @Data
public class Admin {
 
	
	private String email;
	private String password;
	
}
