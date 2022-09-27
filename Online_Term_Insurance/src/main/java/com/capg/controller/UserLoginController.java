package com.capg.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.capg.Repository.UserDetailRepository;
//
//import com.capg.entity.UserDetail;

import com.capg.entity.UserLogin;
import com.capg.repository.UserLoginRepository;


@RestController
@RequestMapping("/user")
public class UserLoginController {

	


	@Autowired
	private UserLoginRepository userRepo ;
 
	LocalDateTime instant;
	
	@PostMapping("/userLogin")
	public Map<String,String> loginUser(@RequestBody UserLogin user)
	{
		 
		 UserLogin detail = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		 
		 if(detail !=null)
		{
			         DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					 instant = LocalDateTime.now();
					 String currentTime =instant.format(myFormatObj);
				   
				     Map<String,String> map=new HashMap<String, String>();
				     map.put("Status Code","202");
					 return map ;
		}
		return null;
		 
	
		

	  
	}
	
}

