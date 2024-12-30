package com.trustMed.insuredServices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException exception, WebRequest request) throws Exception{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
				exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorDetails> handleBadRequestException(BadRequestException exception, WebRequest request) throws Exception{
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),
				exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}