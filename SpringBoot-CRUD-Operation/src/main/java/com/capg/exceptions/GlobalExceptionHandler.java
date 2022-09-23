package com.capg.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Errorinfo> handleIdNotFoundException(IdNotFoundException ex)
	{
		Errorinfo errorinfo = new Errorinfo(new Date(), ex.getMessage(), ex.getMessage());

		return new ResponseEntity<Errorinfo>(errorinfo, HttpStatus.NOT_FOUND);
	}
}
