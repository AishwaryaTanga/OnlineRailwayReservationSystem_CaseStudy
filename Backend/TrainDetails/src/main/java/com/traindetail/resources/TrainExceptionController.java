package com.traindetail.resources;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.traindetail.exception.EmptyInputException;
import com.traindetail.exception.TrainNotfoundException;

@ControllerAdvice
public class TrainExceptionController {
	
	@ExceptionHandler(value=TrainNotfoundException.class)
	public ResponseEntity<Object> exception(TrainNotfoundException exception){
		return new ResponseEntity<>("Train not found", HttpStatus.NOT_FOUND);
		
	}
   
	@ExceptionHandler(value=EmptyInputException.class)
	public ResponseEntity<Object> exception(EmptyInputException exception){
		return new ResponseEntity<>("Input Field is Empty", HttpStatus.BAD_REQUEST);
		
	}

}		
			