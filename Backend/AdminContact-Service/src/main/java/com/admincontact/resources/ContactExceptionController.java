package com.admincontact.resources;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.admincontact.exception.ContactNotfoundException;
import com.admincontact.exception.EmptyInputException;


@ControllerAdvice
public class ContactExceptionController {
	
	@ExceptionHandler(value=ContactNotfoundException.class)
	public ResponseEntity<Object> exception(ContactNotfoundException exception){
		return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(value=EmptyInputException.class)
	public ResponseEntity<Object> exception(EmptyInputException exception){
		return new ResponseEntity<>("Input Field is Empty", HttpStatus.BAD_REQUEST);
		
	}

}