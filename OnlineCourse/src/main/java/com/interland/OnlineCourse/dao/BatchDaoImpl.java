package com.interland.OnlineCourse.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.interland.OnlineCourse.model.TablePref;
import com.interland.OnlineCourse.model.User;

@Repository
public class BatchDaoImpl implements BatchDao{
	@Autowired
	SessionFactory session;

	@SuppressWarnings({ "unchecked", "null" })
	@Transactional
	public List<User> getNewUsers() {
		List<User> resultList = null;
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			criteria.add(Restrictions.eq("send_mail", 0));

			resultList = criteria.list();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultList;
	}

	@Transactional
	public boolean setUserSendMail(User user) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(user);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public boolean setTablePref(TablePref pref) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(pref);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public String getTablePref() {
		TablePref pref = null;
		try {
			pref = (TablePref) session.getCurrentSession().get(TablePref.class, 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		return (pref==null)?"":pref.getPref();
	}
	
	@SuppressWarnings({ "unchecked", "null" })
	@Transactional
	public List<User> getUsers() {
		List<User> resultList = null;
		
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			
			resultList = criteria.list();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultList;
	}
	
	@Transactional
	public boolean delete(int id) {
		boolean flag = false;
		User currConsumer = null;
		try {
			currConsumer = (User) session.getCurrentSession().get(User.class, id);
			if (currConsumer != null) {
				session.getCurrentSession().delete(currConsumer);
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public User getStudent(int id) {
		User currConsumer = null;
		try {
			currConsumer = (User) session.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return currConsumer;
	}
	
	@Transactional
	public boolean addOrUpdate(User user) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(user);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

}
