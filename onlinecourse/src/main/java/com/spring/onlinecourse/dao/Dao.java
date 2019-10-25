package com.spring.onlinecourse.dao;

import com.spring.onlinecourse.dto.UserLogin;
import com.spring.onlinecourse.dto.UserRegister;
import com.spring.onlinecourse.model.User;

public interface Dao {

	

	boolean registerDao(User users);

	User getLogin(UserLogin userLogin);

}
