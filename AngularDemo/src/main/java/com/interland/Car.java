package com.interland;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car() {

	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + "]";
	}
	
	

}