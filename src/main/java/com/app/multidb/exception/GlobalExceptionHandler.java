package com.app.multidb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> employeeNotFound(EmployeeNotFoundException employeeNotFoundException) {
		return new ResponseEntity<>(
				new ErrorResponse(HttpStatus.NOT_FOUND.value(), employeeNotFoundException.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = EmployeeAlreadyExistsException.class, produces = "application/json")
	public ResponseEntity<ErrorResponse> employeeAlreadyExistsException(EmployeeAlreadyExistsException employeeAlreadyExistsException) {
		
		return ResponseEntity.status(HttpStatus.CONFLICT)
        .contentType(MediaType.APPLICATION_JSON)
        .body(new ErrorResponse(HttpStatus.CONFLICT.value(), employeeAlreadyExistsException.getMessage()));
		
	}
}
