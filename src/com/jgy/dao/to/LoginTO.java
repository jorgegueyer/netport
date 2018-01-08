package com.jgy.dao.to;

import java.io.Serializable;

public class LoginTO implements Serializable {

	private static final long serialVersionUID = -5073813184148082505L;
	private int userID;	
	private String username;	
	private String email;
	private String password;
	
	public void setUserID(int userID) {
		this.userID = userID;
	}	
	public int getUserID() {
		return this.userID;
	}	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
