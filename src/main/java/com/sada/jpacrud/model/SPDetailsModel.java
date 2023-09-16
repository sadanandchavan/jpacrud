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
 * Nov 10, 2022 11:00:16 PM
 */
@Entity
@Table(name= "SPDeails")
public class SPDetailsModel {
	
	private long spdId;
	private long spId;
	private String authenticator1;
	private String authenticator2;
	private String authenticator3;
	private String authenticator4;
	private String authenticator5;
	private String authenticator6;
	private String authenticator7;
	private String authenticator8;
	private String authenticator9;
	private String authenticator10;
	private String authenticator11;
	private String authenticator12;
	/**
	 * @return the spdId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getSpdId() {
		return spdId;
	}
	/**
	 * @param spdId the spdId to set
	 */
	public void setSpdId(long spdId) {
		this.spdId = spdId;
	}
	/**
	 * @return the authenticator1
	 */
	public String getAuthenticator1() {
		return authenticator1;
	}
	/**
	 * @param authenticator1 the authenticator1 to set
	 */
	public void setAuthenticator1(String authenticator1) {
		this.authenticator1 = authenticator1;
	}
	/**
	 * @return the authenticator2
	 */
	public String getAuthenticator2() {
		return authenticator2;
	}
	/**
	 * @param authenticator2 the authenticator2 to set
	 */
	public void setAuthenticator2(String authenticator2) {
		this.authenticator2 = authenticator2;
	}
	/**
	 * @return the authenticator3
	 */
	public String getAuthenticator3() {
		return authenticator3;
	}
	/**
	 * @param authenticator3 the authenticator3 to set
	 */
	public void setAuthenticator3(String authenticator3) {
		this.authenticator3 = authenticator3;
	}
	/**
	 * @return the authenticator4
	 */
	public String getAuthenticator4() {
		return authenticator4;
	}
	/**
	 * @param authenticator4 the authenticator4 to set
	 */
	public void setAuthenticator4(String authenticator4) {
		this.authenticator4 = authenticator4;
	}
	/**
	 * @return the authenticator5
	 */
	public String getAuthenticator5() {
		return authenticator5;
	}
	/**
	 * @param authenticator5 the authenticator5 to set
	 */
	public void setAuthenticator5(String authenticator5) {
		this.authenticator5 = authenticator5;
	}
	/**
	 * @return the authenticator6
	 */
	public String getAuthenticator6() {
		return authenticator6;
	}
	/**
	 * @param authenticator6 the authenticator6 to set
	 */
	public void setAuthenticator6(String authenticator6) {
		this.authenticator6 = authenticator6;
	}
	/**
	 * @return the authenticator7
	 */
	public String getAuthenticator7() {
		return authenticator7;
	}
	/**
	 * @param authenticator7 the authenticator7 to set
	 */
	public void setAuthenticator7(String authenticator7) {
		this.authenticator7 = authenticator7;
	}
	/**
	 * @return the authenticator8
	 */
	public String getAuthenticator8() {
		return authenticator8;
	}
	/**
	 * @param authenticator8 the authenticator8 to set
	 */
	public void setAuthenticator8(String authenticator8) {
		this.authenticator8 = authenticator8;
	}
	/**
	 * @return the authenticator9
	 */
	public String getAuthenticator9() {
		return authenticator9;
	}
	/**
	 * @param authenticator9 the authenticator9 to set
	 */
	public void setAuthenticator9(String authenticator9) {
		this.authenticator9 = authenticator9;
	}
	/**
	 * @return the authenticator10
	 */
	public String getAuthenticator10() {
		return authenticator10;
	}
	/**
	 * @param authenticator10 the authenticator10 to set
	 */
	public void setAuthenticator10(String authenticator10) {
		this.authenticator10 = authenticator10;
	}
	/**
	 * @return the authenticator11
	 */
	public String getAuthenticator11() {
		return authenticator11;
	}
	/**
	 * @param authenticator11 the authenticator11 to set
	 */
	public void setAuthenticator11(String authenticator11) {
		this.authenticator11 = authenticator11;
	}
	/**
	 * @return the authenticator12
	 */
	public String getAuthenticator12() {
		return authenticator12;
	}
	/**
	 * @param authenticator12 the authenticator12 to set
	 */
	public void setAuthenticator12(String authenticator12) {
		this.authenticator12 = authenticator12;
	}
	/**
	 * @return the spId
	 */
	public Long getSpId() {
		return spId;
	}
	/**
	 * @param spId the spId to set
	 */
	public void setSpId(Long spId) {
		this.spId = spId;
	}

}
