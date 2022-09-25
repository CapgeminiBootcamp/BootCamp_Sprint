package com.capg.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Table(name = "UserLoginInfo")
@NoArgsConstructor @AllArgsConstructor 
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	
	private String email ;
	private String password;
	
	private String time ; 
}
