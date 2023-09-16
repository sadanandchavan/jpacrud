/**
 * 
 */
package com.sada.jpacrud.exception;

import java.util.Date;

/**
 * @author sadanand chavan
 *
 * Nov 15, 2022 12:46:50 PM
 */
public class CustomAccessDeniedHandler extends Throwable {

	private Date timestamp;
	private String errorCode;
	private String message;
	private String details;
	
	
	
	public CustomAccessDeniedHandler(Date timestamp, String errorCode, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
    }
	
	
}
