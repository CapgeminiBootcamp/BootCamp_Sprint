package com.capg.exceptions;

public class IdNotFoundException extends RuntimeException {

	String msg;
	public IdNotFoundException(String message) {
		super(message);
		this.msg=message;
		// TODO Auto-generated constructor stub
	}

}
