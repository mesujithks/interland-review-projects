package com.user.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.Dao;
import com.user.model.User;

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

	@SuppressWarnings("unchecked")
	public JSONObject getConsumerDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
			try {
				
				
				List<User> lstAllEmployees = dao.searchConsumerDetails(searchParam, sSearch, displaystart, idisplaylength);
					
					  Long rowCount = dao.getRecordCountForConsumerDetails(searchParam, sSearch);
				int i=1;
				for (User userDetails : lstAllEmployees) {
					org.json.simple.JSONObject  objAllEmployees=new org.json.simple.JSONObject();
					objAllEmployees.put("sno", i);
					objAllEmployees.put("name", userDetails.getName());
					objAllEmployees.put("phone", userDetails.getPhone());
					objAllEmployees.put("email", userDetails.getEmail());
					objAllEmployees.put("city", userDetails.getCity());
					objAllEmployees.put("id", userDetails.getId());

					employeeDetailsObjArr.add(objAllEmployees);
					i++;
				}
				res.put("aaData", employeeDetailsObjArr);
				res.put("iTotalDisplayRecords", rowCount); res.put("iTotalRecords",rowCount);
			}catch(Exception e){
			
			}
			return res;
	}
}
