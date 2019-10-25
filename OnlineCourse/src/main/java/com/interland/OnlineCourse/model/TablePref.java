package com.interland.OnlineCourse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data_table_pref")
public class TablePref {
	
	@Id
	Integer id;
	String pref;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPref() {
		return pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	@Override
	public String toString() {
		return "TablePref [id=" + id + ", pref=" + pref + "]";
	}
	
	

}
