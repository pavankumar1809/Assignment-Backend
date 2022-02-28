package com.employeemanagement.backend.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Either username or password is not valid, Please check \nRequirements:"
				+ "\n 1. Username should be Unique. \n 2. Password should contain atleast one each the following: uppercase, lowercase, number, special character";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { InvalidInputsException.class })
	protected ResponseEntity<Object> handleInvalidInputs(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "The posted inputs are not valid, Please check \nRequirements: \n 1. Every input should be atleast 1 chacter and cannot be null. \n "
				+ "2. age should be greater than 19. \n 3. Gender should be either Male or Female. \n 4. Username should be atleast 4 characters "
				+ "\n 5. Password should be of atleast 8 characters. \n 6. Department should be one of the following : HR IT Salary";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}