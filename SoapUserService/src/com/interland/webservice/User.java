package com.interland.webservice;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "date", "age", "gender" } )
public class User implements Serializable{

	private static final long serialVersionUID = -5577579081118070434L;
	
	private Integer id;
	private String name;
	private Date date;
	private int age;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	@XmlJavaTypeAdapter(IdAdapter.class)
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	public void setDate(Date date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", id=" + id + ", date=" + date + "]";
	}

	
}
