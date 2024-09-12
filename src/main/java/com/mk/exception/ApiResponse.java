package com.mk.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class ApiResponse {
	
	
	
	public ApiResponse(String message, HttpStatus status, boolean  success, long timestamp) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
		this.timestamp = timestamp;
	}

	private String message;
	private boolean success;

	private HttpStatus status;

	private long timestamp;


}
