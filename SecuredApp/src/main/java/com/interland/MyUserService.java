package com.interland;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

	@Autowired
	UserRepo dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person p = dao.findByUsername(username);
		if(p==null)
			throw new UsernameNotFoundException("Person 404");
		return new UserPrincipal(p);
	}

}
