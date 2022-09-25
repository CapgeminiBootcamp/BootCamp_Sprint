package com.capg.exception;

import org.springframework.http.HttpStatus;

public class HandlingException extends Exception {
	
	private HttpStatus s ; 
	
	public HandlingException(String msg)
	{
	 
		super(msg);	
	}
	
}
