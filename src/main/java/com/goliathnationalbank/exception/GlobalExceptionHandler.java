package com.goliathnationalbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.micrometer.core.ipc.http.HttpSender;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handlerEntityNotFoundException(EntityNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<String> handlerInsufficientFundsException(InsufficientFundsException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
