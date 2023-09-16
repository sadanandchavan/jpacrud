/**
 * 
 */
package com.sada.jpacrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author sadanand chavan
 *
 * Nov 14, 2022 11:37:17 PM
 */
@Entity
public class UserRole {
	
	private long userRollId;
	private String userId;
	private String password;
	private String rollName;
	private String status;
	/**
	 * @return the userRollId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getUserRollId() {
		return userRollId;
	}
	/**
	 * @param userRollId the userRollId to set
	 */
	public void setUserRollId(long userRollId) {
		this.userRollId = userRollId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the rollName
	 */
	public String getRollName() {
		return rollName;
	}
	/**
	 * @param rollName the rollName to set
	 */
	public void setRollName(String rollName) {
		this.rollName = rollName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
