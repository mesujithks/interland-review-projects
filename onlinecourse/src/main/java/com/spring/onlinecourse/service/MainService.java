package com.spring.onlinecourse.service;

import java.util.HashMap;

import com.spring.onlinecourse.dto.UserLogin;
import com.spring.onlinecourse.dto.UserRegister;
import com.spring.onlinecourse.model.User;


public interface MainService {

	HashMap<String, String> registerService(UserRegister user);

	User loginService(UserLogin userLogin);

	
}
