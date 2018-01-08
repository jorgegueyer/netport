package com.jgy.dao.interfaces;

import java.sql.SQLException;

import com.jgy.dao.to.UserTO;

public interface IUserDAO {	
	
	public abstract UserTO findUserById(int userid) throws SQLException;
	
	public abstract UserTO insertUser(UserTO user) throws SQLException;
	 
	//public abstract String updateUser(UserTO user);
	 
	//public abstract String removeUser(int userid);	
	
}
