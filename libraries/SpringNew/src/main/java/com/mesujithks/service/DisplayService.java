package com.mesujithks.service;


import java.util.List;

import com.mesujithks.model.User;

public interface DisplayService {
	public List<User> display();
	public void addOrUpdate(User user);
	public User getUpdate(User user);
	public void delete(User user);
}
