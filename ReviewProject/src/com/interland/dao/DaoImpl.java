package com.interland.dao;

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

import com.interland.model.Consumer;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Consumer> display() {

		List<Consumer> beanList = null;
		try {
			beanList = session.getCurrentSession().createCriteria(Consumer.class).list();
		} catch (Exception e) {
			System.out.println(e);
		}
		return beanList;
	}

	@Transactional
	public boolean addOrUpdate(Consumer consumer) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(consumer);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public Consumer getUpdate(int id) {
		Consumer currConsumer = null;
		try {
			currConsumer = (Consumer) session.getCurrentSession().get(Consumer.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return currConsumer;
	}

	@Transactional
	public boolean delete(int id) {
		boolean flag = false;
		Consumer currConsumer = null;
		try {
			currConsumer = (Consumer) session.getCurrentSession().get(Consumer.class, id);
			if(currConsumer !=null) {
				session.getCurrentSession().delete(currConsumer);
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Consumer> searchConsumerDetails(String searchParam, String sSearch, int displaystart,
			int idisplaylength) {
		List<Consumer> result = null;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(Consumer.class);

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("name", employeeCode+"%"));
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
			Criteria criteria = curSession.createCriteria(Consumer.class);

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("name", employeeCode+"%"));
			}

			count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {

		}
		return count;
	}
}
