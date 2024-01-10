package com.qsp.CMS.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingPlace {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> entity(IdNotFoundException i)
	{
		return new ResponseEntity<>(i.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordInvalid.class)
	public ResponseEntity<?> entity(PasswordInvalid p){
		return new ResponseEntity<>(p.getMessage(),HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler
	public ResponseEntity<?> entity(EmailNotValidException e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
