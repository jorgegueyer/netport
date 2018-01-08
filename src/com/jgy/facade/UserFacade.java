package com.jgy.facade;

import java.sql.SQLException;

import com.jgy.dao.DAOFactory;
import com.jgy.dao.interfaces.IUserDAO;
import com.jgy.dao.to.UserTO;

public class UserFacade {
	
	public UserTO getUserById(int userid)  throws SQLException{	
		IUserDAO userDao = DAOFactory.getInstance().getUserDAO();
		return userDao.findUserById(userid);
	}
	
	public UserTO createUser(UserTO user)  throws SQLException{
		IUserDAO userDao = DAOFactory.getInstance().getUserDAO();
		return userDao.insertUser(user);
	}
}
