package com.jgy.dao.interfaces;

import java.sql.SQLException;

import com.jgy.dao.to.LoginTO;

public interface ILoginDAO {
	
	public abstract LoginTO findLogin(String username, String password) throws SQLException;
	
	public abstract LoginTO insertLogin(LoginTO login) throws SQLException;
}