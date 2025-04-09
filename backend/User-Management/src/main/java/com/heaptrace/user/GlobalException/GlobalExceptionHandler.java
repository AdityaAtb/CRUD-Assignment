package com.heaptrace.user.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.heaptrace.user.dto.ApiResponse;
import com.heaptrace.user.exception.FieldNotAvailableException;
import com.heaptrace.user.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiResponse handleRuntimeException(RuntimeException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(FieldNotAvailableException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ApiResponse handleFieldNotAvailableException(RuntimeException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiResponse handleResourceNotFoundException(RuntimeException e) {
		return new ApiResponse(e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ApiResponse("Validation failed: " + e.getMessage());
    }
}
