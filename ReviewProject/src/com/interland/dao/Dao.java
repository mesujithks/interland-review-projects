package com.interland.dao;

import java.util.List;

import com.interland.model.Consumer;

public interface Dao {
	public List<Consumer> display();
	public boolean addOrUpdate(Consumer user);
	public Consumer getUpdate(int id);
	public boolean delete(int id);
	public List<Consumer> searchConsumerDetails(String searchParam, String sSearch, int displaystart,
			int idisplaylength);
	public Long getRecordCountForConsumerDetails(String searchParam, String sSearch);
}
