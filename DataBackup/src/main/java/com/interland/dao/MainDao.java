package com.interland.dao;

import java.util.List;

import com.interland.entities.Backup;
import com.interland.entities.Main;


public interface MainDao {
	
	public Integer insert(Backup main);
	
	public Integer insert(Main main);
	
	public void delete(Main main);

	public Long getCountRecordsByDate();

	List<Main> findRecordsByDate(int offset, int limit);
	
}
