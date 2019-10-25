package com.mesujithks.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mesujithks.model.User;
@Repository
public class DaoImpl implements Dao{
	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> display(){
		
		List<User> beanList=null;
		try {
			beanList=session.getCurrentSession().createCriteria(User.class).list();
		} catch (Exception e) {
			System.out.println(e);
		}
		return beanList;
	}
	
	@Transactional
	public void addOrUpdate(User user) {
		try {
			session.getCurrentSession().saveOrUpdate(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Transactional
	public User getUpdate(User user) {
		User currUser=new User();
		try {
			currUser=(User)session.getCurrentSession().get(User.class,user.getId());
		} catch (Exception e) {
			System.out.println(e);
		}
		return currUser;
	}

	
	@Transactional
	public void delete(User user) {
		try {
			session.getCurrentSession().delete(user);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
