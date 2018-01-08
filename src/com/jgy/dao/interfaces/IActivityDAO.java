package com.jgy.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.jgy.dao.to.ActivityTO;

public interface IActivityDAO {

	public abstract List<ActivityTO> findActivitiesByUser(int userid) throws SQLException;
}
