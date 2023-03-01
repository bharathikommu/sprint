package com.batch2.onlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.batch2.onlineshopping.dto.ErrorMessage;

public class GlobalExceptions extends Exception {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getHttpStatus()).body(message);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> productNotFoundException(ProductNotFoundException exception,
			WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getHttpStatus()).body(message);
	}
	
	@ExceptionHandler(InvalidProductDetails.class)
	public ResponseEntity<ErrorMessage> invalidProductDetails(InvalidProductDetails exception, WebRequest webRequest) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		return ResponseEntity.status(message.getHttpStatus()).body(message);                    
	}
}
