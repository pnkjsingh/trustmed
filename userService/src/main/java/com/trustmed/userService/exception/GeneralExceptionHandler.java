package com.trustmed.userService.exception;
//package com.trustmed.userService.exception;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import org.springframework.http.HttpStatus;
//
//@RestControllerAdvice
//public class GeneralExceptionHandler {
//
//	@ExceptionHandler(NotFoundException.class)
//	public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//	}
//
//	@ExceptionHandler(BadRequestException.class)
//	public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//	}
//
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleGeneralException(Exception ex) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
//	}	
//}