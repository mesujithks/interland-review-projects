package com.user.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.user.model.User;
@Repository
public class DaoImpl implements Dao{
	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> display(){
		
		List<User> beanList=null;
		try {
			beanList=(List<User>) session.getCurrentSession().createCriteria(User.class).list();
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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> searchConsumerDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		List<User> result = null;
		JSONParser parser = new JSONParser();
		try {
			
			Criteria criteria = session.getCurrentSession().createCriteria(User.class);

			String name = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				name = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(name)) {
				criteria.add(Restrictions.like("name", name+"%"));
			}

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	@Transactional
	public Long getRecordCountForConsumerDetails(String searchParam, String sSearch) {
		Long count = (long) 0;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);

			String name = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				name = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(name)) {
				criteria.add(Restrictions.like("name", name+"%"));
			}

			count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {

		}
		return count;
	}
}
