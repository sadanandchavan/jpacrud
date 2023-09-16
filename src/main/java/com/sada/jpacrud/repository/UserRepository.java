/**
 * 
 */
package com.sada.jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sada.jpacrud.model.UserModel;

/**
 * @author sadanand chavan
 *
 * Nov 8, 2022 10:06:42 PM
 */
public interface UserRepository extends JpaRepository<UserModel, Long> {

	/**
	 * @param userModel
	 */
	List <UserModel> findByMobileNoAndPassword(String mobileNo, String password);

}
