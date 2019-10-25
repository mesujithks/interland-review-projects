package com.interland.OnlineCourse.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

}
