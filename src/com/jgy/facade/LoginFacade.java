package com.jgy.facade;

import java.sql.SQLException;

import com.jgy.dao.DAOFactory;
import com.jgy.dao.interfaces.ILoginDAO;
import com.jgy.dao.to.LoginTO;

public class LoginFacade {
	
	public LoginTO login(String email, String password) throws SQLException {	
		ILoginDAO loginDao = DAOFactory.getInstance().getLoginDAO();
		return loginDao.findLogin(email, password);
	}
	
	public LoginTO createLogin(LoginTO login) throws SQLException {	
		ILoginDAO loginDao = DAOFactory.getInstance().getLoginDAO();
		return loginDao.insertLogin(login);
	}
}