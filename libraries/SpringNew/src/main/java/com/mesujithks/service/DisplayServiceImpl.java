package com.mesujithks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mesujithks.dao.Dao;
import com.mesujithks.model.User;

@Service
public class DisplayServiceImpl implements DisplayService {
	@Autowired
	Dao dao;

	public List<User> display() {
		List<User> beanList = dao.display();
		return beanList;
	}

	public void addOrUpdate(User user) {
		dao.addOrUpdate(user);
	}

	public User getUpdate(User user) {
		return dao.getUpdate(user);
	}

	public void delete(User user) {
		dao.delete(user);
	}
}
