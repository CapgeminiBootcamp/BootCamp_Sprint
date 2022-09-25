package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
	
	public UserLogin findByEmailAndPassword(String email,String password);
}
