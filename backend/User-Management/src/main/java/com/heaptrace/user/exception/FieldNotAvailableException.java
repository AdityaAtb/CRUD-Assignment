package com.heaptrace.user.exception;

public class FieldNotAvailableException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public FieldNotAvailableException(String message) {
		super(message);
	}
}
