/**
 * 
 */
package com.sada.jpacrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sadanand chavan
 *
 * Nov 5, 2022 8:09:39 PM
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InvalidCredentials extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCredentials(String message){
	        super(message);
	    }
}
