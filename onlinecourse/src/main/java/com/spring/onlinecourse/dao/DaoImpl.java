package com.spring.onlinecourse.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.onlinecourse.dto.UserLogin;
import com.spring.onlinecourse.dto.UserRegister;
import com.spring.onlinecourse.model.User;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory session;

	@Transactional
	public boolean registerDao(User users) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(users);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
@Transactional
	public User getLogin(UserLogin userLogin) {
		User user = null;
		try {
			Criteria cr = session.getCurrentSession().createCriteria(User.class);
			cr.add(Restrictions.eq("email", userLogin.getUsername()));
			cr.add(Restrictions.eq("pass", userLogin.getPassword()));
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List<User> results = cr.list();
			Set<User> hSet = new HashSet();
			for (User x : results)
				hSet.add(x);

			System.out.println(results);
			if (hSet.size() == 1) {
				user = (User) results.get(0);
				System.out.println(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;

	}

}
