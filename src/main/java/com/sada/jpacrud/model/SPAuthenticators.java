/**
 * 
 */
package com.sada.jpacrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sadanand chavan
 *
 * Nov 10, 2022 6:50:25 PM
 */

@Entity
@Table(name= "SPAuthenticators")
public class SPAuthenticators {
	
	private long authId;
	private String spId;
	private String paramName;
	private String dataType;
	private String regex;
	private String errorMsg;
	private String sequence;
	/**
	 * @return the authId
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getAuthId() {
		return authId;
	}
	/**
	 * @param authId the authId to set
	 */
	public void setAuthId(long authId) {
		this.authId = authId;
	}
	/**
	 * @return the spId
	 */
	public String getSpId() {
		return spId;
	}
	/**
	 * @param spId the spId to set
	 */
	public void setSpId(String spId) {
		this.spId = spId;
	}
	/**
	 * @return the paramName
	 */
	public String getParamName() {
		return paramName;
	}
	/**
	 * @param paramName the paramName to set
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}
	/**
	 * @param regex the regex to set
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}
	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the sequence
	 */
	public String getSequence() {
		return sequence;
	}
	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}


}
