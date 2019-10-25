package com.spring.SecurityApp.dao;

import com.spring.SecurityApp.model.User;

public interface UserDao {

	User findByUserName(String username);

}
