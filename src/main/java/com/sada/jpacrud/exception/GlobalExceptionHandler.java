/**
 * 
 */
package com.sada.jpacrud.exception;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author sadanand chavan
 *
 * Nov 6, 2022 12:14:20 AM
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger   = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		logger.error("ResourceNotFoundException occured.");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		logger.error("GlobleExcpetionHandler occured.");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ServletException.class)
	public ResponseEntity<?> servletExceptionHandler(Exception ex, WebRequest request) {
		logger.error("servletExceptionHandler occured.");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> ioExcpetionHandler(Exception ex, WebRequest request) {
		logger.error("ioExcpetionHandler occured.");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<?> InvalidCredentialsHandler(Exception ex, WebRequest request) {
		logger.error("GlobleExcpetionHandler occured.");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
