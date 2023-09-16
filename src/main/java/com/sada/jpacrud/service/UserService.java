/**
 * 
 */
package com.sada.jpacrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sada.jpacrud.model.UserModel;
import com.sada.jpacrud.repository.UserRepository;

/**
 * @author sadanand chavan
 *
 * Nov 8, 2022 10:11:50 PM
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	/**
	 * @param userModel
	 * @return
	 */
	public UserModel loginUser(UserModel userModel) {
		List <UserModel> userList= userRepository.findByMobileNoAndPassword(userModel.getMobileNo(),userModel.getPassword());
		return userList.get(0);
	}
	/**
	 * @param serviceProviderModel
	 * @return
	 */
	public UserModel createUser(UserModel userModel) {
		return userRepository.save(userModel);
	}

}
