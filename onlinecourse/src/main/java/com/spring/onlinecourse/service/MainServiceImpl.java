package com.spring.onlinecourse.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.onlinecourse.dao.Dao;
import com.spring.onlinecourse.dto.UserLogin;
import com.spring.onlinecourse.dto.UserRegister;
import com.spring.onlinecourse.model.User;


@Service
public class MainServiceImpl  implements MainService{
@Autowired
Dao dao;
public HashMap<String, String> registerService(UserRegister user) {
	User users = new User();
	HashMap<String, String> response = new HashMap<String, String>();
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // Strength set as 12

	try {
		users.setName(user.getName());
		users.setEmail(user.getEmail());
		users.setPass(user.getPassword());
		users.setType(user.getType());
		users.setMobile(user.getMobile());
		users.setGender(user.getGender());
		users.setImage("/resources/upload/images/avatar.png");
		users.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob()));

		System.out.println(encoder.encode(user.getPassword()));
		if (dao.registerDao(users)) {
			response.put("flag", "true");
			response.put("message", "Success");
		} else {
			response.put("flag", "false");
			response.put("message", "Error");
		}

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return response;
}
public User loginService(UserLogin userLogin) {
	User user = null;
	
	try {
		user = dao.getLogin(userLogin);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return user;
}
		
	}
	
	


