/**
 * 
 */
package com.sada.jpacrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sada.jpacrud.model.UserModel;
import com.sada.jpacrud.service.UserService;
import com.sada.jpacrud.util.JwtUtil;

/**
 * @author sadanand chavan
 *
 * Nov 8, 2022 10:05:14 PM
 */
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins="*")
public class UserController {
	
	Logger logger   = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/user")
	public UserModel createUser(@Validated @RequestBody UserModel userModel) {
		//return serviceProviderService.save(serviceProviderModel);
		UserModel user = userService.createUser(userModel);
		//logger.info("User saved "+user.getFirstName());
		return user;
	}
	/*
	@GetMapping("/user/login")
	public List<UserModel> loginUser(@RequestBody UserModel userModel)
			throws ResourceNotFoundException {
		logger.info("loginServiceProvider called for ="+userModel.getMobileNo()+" Password= "+userModel.getPassword());
		List<UserModel> user = userService.loginUser(userModel);
		//List<UserModel> list = new ArrayList<UserModel>();
		//list.add(user);
		return user;
	}
	*/
	
	@GetMapping("/userLogin")
	public List <UserModel> loginUser(@RequestParam String mobileNo, @RequestParam String password)
			throws Exception {
		UserModel userModel = new UserModel();
		userModel.setMobileNo(mobileNo);
		userModel.setPassword(password);
		logger.info("loginServiceProvider called for ="+userModel.getMobileNo()+" Password= "+userModel.getPassword());
		UserModel user = userService.loginUser(userModel);
		logger.info("Login : "+user.toString());
		user.setToken(jwtUtil.generateToken(user.getMobileNo()));
		List<UserModel> userList = new ArrayList<UserModel>();
		userList.add(user);
		return userList;
	}
}
