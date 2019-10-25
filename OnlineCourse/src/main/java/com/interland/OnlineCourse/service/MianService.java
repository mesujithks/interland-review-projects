package com.interland.OnlineCourse.service;

import java.util.HashMap;

import com.interland.OnlineCourse.dto.UserLogin;
import com.interland.OnlineCourse.dto.UserRegister;
import com.interland.OnlineCourse.model.User;

public interface MianService {
	
	public HashMap<String, String> registerService(UserRegister userRegister);

	public User loginService(UserLogin userLogin);
	
	public void mailShcedule();

}
