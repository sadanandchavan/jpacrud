/**
 * 
 */
package com.sada.jpacrud.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sada.jpacrud.exception.ResourceNotFoundException;
import com.sada.jpacrud.model.UserRole;
import com.sada.jpacrud.repository.UserRoleRepository;
import com.sada.jpacrud.util.Authority;

/**
 * @author sadanand chavan
 *
 * Nov 14, 2022 11:41:38 PM
 */

@Service
public class UserRoleService implements UserDetailsService {
	
	@Autowired
	private UserRoleRepository serviceRepository;

	public UserDetails loadUserByUsername(String mobileNo) throws UsernameNotFoundException {
		UserRole user = serviceRepository.findByUserId(mobileNo);
        //return new org.springframework.security.core.userdetails.User(user.getMobileNo(), user.getPassword(), new ArrayList<>());
		 return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), getAuthority(user));
	}
	
	private Set getAuthority(UserRole user) {
        Set <Authority>authorities = new HashSet<Authority>();
       // GrantedAuthority authority = new GrantedAuthority();
        Authority authority = new Authority();
        authority.setAuthority(user.getRollName());
        authorities.add(authority);
		return authorities;
	}
	
	public UserRole findById(String mobileNo) throws ResourceNotFoundException {
		UserRole user = serviceRepository.findByUserId(mobileNo);
		return user;
	}
	
}
