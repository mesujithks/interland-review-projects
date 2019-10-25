package com.interland.OnlineCourse.dao;

import java.util.List;

import com.interland.OnlineCourse.model.TablePref;
import com.interland.OnlineCourse.model.User;

public interface BatchDao {
	
	public List<User> getNewUsers();
	
	public boolean setUserSendMail(User user);
	
	public boolean setTablePref(TablePref pref);
	
	public String getTablePref();
	
	public List<User> getUsers();
	
	public boolean delete(int id);
	
	public User getStudent(int id);
	
	public boolean addOrUpdate(User user);
	

}
