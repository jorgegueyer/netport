package com.jgy.dao;

import com.jgy.dao.interfaces.IActivityDAO;
import com.jgy.dao.interfaces.ILoginDAO;
import com.jgy.dao.interfaces.IUserDAO;
import com.jgy.dao.objects.ActivityDAO;
import com.jgy.dao.objects.LoginDAO;
import com.jgy.dao.objects.UserDAO;

/**
 * 
 * Factory to instantiate the each Data Access Object	
 * @author Jorge Guerra Yerpes 
 * 
 */
public class DAOFactory {

	private static DAOFactory daoFac;
    
    static {
        daoFac = new DAOFactory();
    }
    
    public static DAOFactory getInstance(){
        return daoFac;
    }        
    
    public IUserDAO getUserDAO(){
        return new UserDAO();
    }
    
    public ILoginDAO getLoginDAO(){
        return new LoginDAO();
    }
    
    public IActivityDAO getActivityDAO(){
        return new ActivityDAO();
    }
}