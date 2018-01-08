package com.jgy.dao.to;

import java.io.Serializable;
import java.util.Date;

public class UserTO implements Serializable {

	private static final long serialVersionUID = -5073813184148082505L;
	private int id;	
	private String name;
	private String surname;
	private Date birthday;
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}	
}
