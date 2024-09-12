package com.mk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse>test(ResourceNotFound ex)
	{
	
	ApiResponse apiResponse=new ApiResponse (ex.getMessage(),HttpStatus.NOT_FOUND,false,System.currentTimeMillis());
	
	
	return new 	ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
