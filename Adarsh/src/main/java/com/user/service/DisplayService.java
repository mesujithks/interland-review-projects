package com.user.service;


import java.util.List;

import org.json.simple.JSONObject;

import com.user.model.User;

public interface DisplayService {
	public List<User> display();
	public void addOrUpdate(User user);
	public User getUpdate(User user);
	public void delete(User user);
	public JSONObject getConsumerDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);
}
