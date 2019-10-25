package com.interland.service;

import java.util.List;


import com.interland.model.Consumer;

public interface ConsumerService {
	public List<Consumer> viewAll();
	public String add(Consumer consumer);
	public String update(Consumer consumer);
	public String getUpdate(int id);
	public String delete(int id);
	public org.json.simple.JSONObject getConsumerDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);
}
