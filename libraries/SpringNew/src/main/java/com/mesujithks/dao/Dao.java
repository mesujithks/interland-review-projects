package com.mesujithks.dao;

import java.util.List;

import com.mesujithks.model.User;

public interface Dao {
	public List<User> display();
	public void addOrUpdate(User user);
	public User getUpdate(User user);
	public void delete(User user);
}
