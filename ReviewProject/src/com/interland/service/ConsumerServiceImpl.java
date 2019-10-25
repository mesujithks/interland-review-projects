package com.interland.service;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interland.dao.Dao;
import com.interland.model.Consumer;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	@Autowired
	Dao dao;

	public List<Consumer> viewAll() {
		List<Consumer> beanList = null;
		try {
			beanList = dao.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}

	public String add(Consumer consumer) {
		HashMap<String, String> message = new HashMap<String, String>();
		message.put("page", "add");
		try {
			if (dao.addOrUpdate(consumer)) {
				message.put("type", "alert-success");
				message.put("data", "New Consumer Added.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while adding Consumer! Please Try Again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject(message).toString();
	}

	public String update(Consumer consumer) {
		HashMap<String, String> message = new HashMap<String, String>();
		message.put("page", "edit");
		try {
			if (dao.addOrUpdate(consumer)) {
				message.put("type", "alert-success");
				message.put("data", "Consumer Updated.");
			} else {
				message.put("type", "alert-danger");
				message.put("data", "Error while updating Consumer! Please Try Again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JSONObject(message).toString();
	}

	public String getUpdate(int id) {
		String json = "{}";
		Consumer consumer = null;
		try {
			consumer = dao.getUpdate(id);
			if(consumer != null)
				json = new JSONObject(consumer).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public String delete(int id) {
		String message = "0";
		try {
			if (dao.delete(id))
				message = "1";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public org.json.simple.JSONObject getConsumerDetails(String searchParam, String sSearch, int displaystart, int idisplaylength) {

		org.json.simple.JSONObject res = new org.json.simple.JSONObject();
		org.json.simple.JSONArray employeeDetailsObjArr = new org.json.simple.JSONArray();
			try {
				
				
				List<Consumer> lstAllEmployees = dao.searchConsumerDetails(searchParam, sSearch, displaystart, idisplaylength);
					
					  Long rowCount = dao.getRecordCountForConsumerDetails(searchParam, sSearch);
					 
				for (Consumer userDetails : lstAllEmployees) {
					org.json.simple.JSONObject  objAllEmployees=new org.json.simple.JSONObject();
				   
					objAllEmployees.put("name", userDetails.getName());
					objAllEmployees.put("age", userDetails.getAge());
					objAllEmployees.put("phone", userDetails.getPhone());
					objAllEmployees.put("email", userDetails.getEmail());
					objAllEmployees.put("amount", userDetails.getAmount());
					objAllEmployees.put("id", userDetails.getId());

					employeeDetailsObjArr.add(objAllEmployees);
				}
				res.put("aaData", employeeDetailsObjArr);
				res.put("iTotalDisplayRecords", rowCount); res.put("iTotalRecords",rowCount);
			}catch(Exception e){
			
			}
			return res;
	}
}
