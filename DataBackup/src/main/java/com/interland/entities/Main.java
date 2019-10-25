package com.interland.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Main {
	
	@Id
	@GeneratedValue
	Integer id;
	
	LocalDate date;
	
	public Main() {
	}
	
	public Main(LocalDate date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Main [id=" + id + ", date=" + date + "]";
	}	

}
