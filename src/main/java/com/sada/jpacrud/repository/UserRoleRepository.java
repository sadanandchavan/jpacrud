/**
 * 
 */
package com.sada.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sada.jpacrud.model.UserRole;

/**
 * @author sadanand chavan
 *
 * Nov 14, 2022 11:49:00 PM
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	/**
	 * @param mobileNo
	 * @return
	 */
	UserRole findByUserId(String mobileNo);

}
