package com.interland.OnlineCourse.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.interland.OnlineCourse.dto.UserLogin;
import com.interland.OnlineCourse.model.Content;
import com.interland.OnlineCourse.model.Course;
import com.interland.OnlineCourse.model.Notice;
import com.interland.OnlineCourse.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory session;

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

	@Transactional
	public User getLogin(UserLogin userLogin) {
		User user = null;
		try {
			Criteria cr = session.getCurrentSession().createCriteria(User.class);
			cr.add(Restrictions.eq("email", userLogin.getUsername()));
			cr.add(Restrictions.eq("pass", userLogin.getPassword()));
		
			@SuppressWarnings("unchecked")
			List<User> results = cr.list();
			Set<User> hSet = new HashSet<User>();
			for (User x : results)
			hSet.add(x);
			

			//System.out.println(results);
			if (hSet.size() == 1) {
				user = (User) results.get(0);
				System.out.println(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> searchStudentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		List<User> result = null;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			criteria.add(Restrictions.eq("type", "student"));

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("name", employeeCode + "%"));
			}

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list();
			 System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Transactional
	public Long getRecordCountForStudentDetails(String searchParam, String sSearch) {
		Long count = (long) 0;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			criteria.add(Restrictions.eq("type", "student"));
			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("name", employeeCode + "%"));
			}

			count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {

		}
		return count;
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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> searchFacultyDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		List<User> result = null;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			criteria.add(Restrictions.eq("type", "faculty"));

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("name", employeeCode + "%"));
			}

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list();
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Transactional
	public Long getRecordCountForFacultyDetails(String searchParam, String sSearch) {
		Long count = (long) 0;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			criteria.add(Restrictions.eq("type", "faculty"));
			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("name", employeeCode + "%"));
			}

			count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {

		}
		return count;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Course> searchCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		List<Course> result = null;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(Course.class);

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("courseName", employeeCode + "%"));
			}

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list();
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Transactional
	public Long getRecordCountForCourseDetails(String searchParam, String sSearch) {
		Long count = (long) 0;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(Course.class);

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("courseName", employeeCode + "%"));
			}

			count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {

		}
		return count;
	}

	@Transactional
	public boolean addOrUpdateCourse(Course course) {

		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(course);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;

	}

	@Transactional
	public Course getCourse(int id) {
		Course currConsumer = null;
		try {
			currConsumer = (Course) session.getCurrentSession().get(Course.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return currConsumer;
	}

	@Transactional
	public boolean deleteCourse(int id) {
		boolean flag = false;
		Course currConsumer = null;
		try {
			currConsumer = (Course) session.getCurrentSession().get(Course.class, id);
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
	@SuppressWarnings("unchecked")
	public List<Notice> searchNoticeDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		List<Notice> result = null;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(Notice.class);
			// criteria.add(Restrictions.eq("type", "student"));

			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("title", employeeCode + "%"));
			}

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list();
			// System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Transactional
	public Long getRecordCountForNoticeDetails(String searchParam, String sSearch) {
		Long count = (long) 0;
		JSONParser parser = new JSONParser();
		try {
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(Notice.class);
			// criteria.add(Restrictions.eq("type", "student"));
			String employeeCode = null;

			if (!StringUtils.isEmpty(searchParam)) {
				org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
				employeeCode = (String) searchObject.get("employeeCode");

			}

			if (!StringUtils.isEmpty(employeeCode)) {
				criteria.add(Restrictions.like("title", employeeCode + "%"));
			}

			count = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {

		}
		return count;
	}

	@Transactional
	public boolean addOrUpdateNotice(Notice notice) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(notice);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public Notice getNotice(int id) {
		Notice currConsumer = null;
		try {
			currConsumer = (Notice) session.getCurrentSession().get(Notice.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return currConsumer;
	}

	@Transactional
	public boolean deleteNotice(int id) {
		boolean flag = false;
		Notice currConsumer = null;
		try {
			currConsumer = (Notice) session.getCurrentSession().get(Notice.class, id);
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
	public boolean updateStudent(User user) {
		boolean flag = false;
		try {
			session.getCurrentSession().update(user);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public Set<Course> searchMyCourseDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id) {
		Set<Course> result = null;
		User student = null;
		try {
			student = getStudent(id);
			result = student.getCourses();
			// System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Transactional
	public Set<Course> searchMyCourseDetailsFaculty(String searchParam, String sSearch, int displaystart,
			int idisplaylength, int id) {
		Set<Course> result = null;
		User faculty = null;
		try {
			faculty = getFaculty(id);
			result = faculty.getCourses();
			// System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Transactional
	public User getFaculty(int id) {
		User currConsumer = null;
		try {
			currConsumer = (User) session.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return currConsumer;
	}

	@Transactional
	public boolean updateFaculty(User user) {
		boolean flag = false;
		try {
			session.getCurrentSession().update(user);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public boolean deleteContent(int id) {
		boolean flag = false;
		Content currConsumer = null;
		try {
			currConsumer = (Content) session.getCurrentSession().get(Content.class, id);
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
	public boolean addOrUpdateContent(Content content) {
		boolean flag = false;
		try {
			session.getCurrentSession().saveOrUpdate(content);
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	@Transactional
	public Content getContent(int id) {
		Content currConsumer = null;
		try {
			currConsumer = (Content) session.getCurrentSession().get(Content.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return currConsumer;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Content> searchContentDetails(String searchParam, String sSearch, int displaystart, int idisplaylength,
			int id) {

		List<Content> result = null;

		JSONParser parser = new JSONParser();
		try {
			org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
			int cid = Integer.parseInt((String) searchObject.get("crsid"));
System.out.println(id+":"+cid);
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(Content.class);
			//criteria.add(Restrictions.eq("id", id));
			//criteria.add(Restrictions.eq("courseId", cid));

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list(); 
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Transactional
	public List<User> searchCourseStudents(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		List<User> result = null;

		JSONParser parser = new JSONParser();
		try {
			org.json.simple.JSONObject searchObject = (org.json.simple.JSONObject) parser.parse(searchParam);
			int cid = Integer.parseInt((String) searchObject.get("crsid"));
			System.out.println("cid: "+cid);
			Session curSession = session.getCurrentSession();
			Criteria criteria = curSession.createCriteria(User.class);
			criteria.createAlias("courses", "coursesAlias");
			criteria.add(Restrictions.eq("coursesAlias.courseId", cid));
			criteria.add(Restrictions.eq("type", "student"));

			criteria.setMaxResults(idisplaylength);
			criteria.setFirstResult(displaystart);
			result = criteria.list(); 
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

}
