package com.bookingorder.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookingorder.exception.BookingNotfoundException;
import com.bookingorder.exception.EmptyInputException;

@ControllerAdvice
public class BookingOrderExceptionController {

	@ExceptionHandler(value=BookingNotfoundException.class)
	public ResponseEntity<Object> exception(BookingNotfoundException exception){
		return new ResponseEntity<>("Booking not found", HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(value=EmptyInputException.class)
	public ResponseEntity<Object> exception(EmptyInputException exception){
		return new ResponseEntity<>("Input Field is Empty", HttpStatus.BAD_REQUEST);
		
	}
}
