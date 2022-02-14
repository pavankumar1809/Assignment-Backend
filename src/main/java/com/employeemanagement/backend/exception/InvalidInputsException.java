package com.employeemanagement.backend.exception;

public class InvalidInputsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidInputsException(String message) {
		super(message);
	}
}
