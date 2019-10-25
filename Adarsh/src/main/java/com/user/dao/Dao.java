package com.user.dao;

import java.util.List;

import com.user.model.User;

public interface Dao {
	public List<User> display();
	public void addOrUpdate(User user);
	public User getUpdate(User user);
	public void delete(User user);
	public List<User> searchConsumerDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);
	public Long getRecordCountForConsumerDetails(String searchParam, String sSearch);
}
