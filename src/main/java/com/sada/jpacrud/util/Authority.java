/**
 * 
 */
package com.sada.jpacrud.util;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author sadanand chavan
 *
 * Nov 15, 2022 11:03:59 AM
 */
public class Authority implements GrantedAuthority{

	private String authority;
	@Override
	public String getAuthority() {
		return this.authority;
	}
	public String setAuthority( String authority) {
		return this.authority =authority;
	}
}
