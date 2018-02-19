package com.jgy.dao.to;

import java.io.Serializable;
import java.time.LocalDate;

public class UserTO implements Serializable {

	private static final long serialVersionUID = -5073813184148082505L;
	private int id;	
	private String name;
	private String surname;
	private LocalDate birthday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthday() {
		return this.birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}	
}
