package com.jgy.facade;

import java.sql.SQLException;
import java.util.List;

import com.jgy.dao.DAOFactory;
import com.jgy.dao.interfaces.IActivityDAO;
import com.jgy.dao.to.ActivityTO;

public class ActivityFacade {
	
	public List<ActivityTO> getActivitiesByUser(int userid) throws SQLException {
		IActivityDAO activityDao = DAOFactory.getInstance().getActivityDAO();
		return activityDao.findActivitiesByUser(userid);		
	}
}