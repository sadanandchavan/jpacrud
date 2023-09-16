/**
 * 
 */
package com.sada.jpacrud.exception;

import java.util.Date;

/**
 * @author sadanand chavan
 *
 * Nov 6, 2022 12:12:48 AM
 */
public class ErrorDetails {
	private Date timestamp;
	private String errorCode;
	private String message;
	private String details;
	
	
	
	public ErrorDetails(Date timestamp, String errorCode, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.errorCode = errorCode;
        this.message = message;
        this.details = details;
    }
	
	public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
