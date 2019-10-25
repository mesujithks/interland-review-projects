package com.interland.test;

import java.util.Arrays;
import java.util.List;

import com.interland.webservice.User;
import com.interland.webservice.UserArray;
import com.interland.webservice.UserService;
import com.interland.webservice.UserServiceImplService;

public class SoapUserClient {
	 
	  
    public static void main(String[] args) {
        
    	UserServiceImplService userService = new UserServiceImplService();
    	UserService user = userService.getUserServiceImplPort();
		/*
		 * User u = new User(); u.setId(2); u.setName("Kunchu"); u.setAge(22);
		 */
    	 List<UserArray> list = Arrays.asList(user.getAllUsers());  
    	 for(UserArray u:list)
    		System.out.println(u.getItem());
    }
}