package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Customer;
import com.capg.entity.UserLogin;
import com.capg.repository.UserLoginRepository;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private UserLoginRepository repository;
	
	@Override
	public UserLogin addUser(UserLogin login) {
		repository.save(login);
		return login;
	}
}