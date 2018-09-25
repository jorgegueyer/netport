package com.jgy.dao.objects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jgy.dao.DBConn;
import com.jgy.dao.interfaces.IActivityDAO;
import com.jgy.dao.to.ActivityTO;

/**
 * 
 * DAO to obtain data from the Activity table	
 * @author Jorge Guerra Yerpes 
 * 
 */
public class ActivityDAO implements IActivityDAO {
	
	public List<ActivityTO> findActivitiesByUser(int userid) throws SQLException {
		
		List<ActivityTO> list = null;		
		String query  = "SELECT * FROM Activity ";
		query += "WHERE Userid='" + userid + "'";
		
		try (
				Connection conn = DBConn.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
		) {	
			
            ResultSet rs = stmt.executeQuery();            
            list = new ArrayList<ActivityTO>();            
            
            if (rs.next()) {
            	ActivityTO activity = new ActivityTO();
            	activity.setUserid(rs.getInt("Userid"));
            	activity.setName(rs.getString("Name"));
            	activity.setType(rs.getString("Type"));
            	activity.setDuration(rs.getTime("Duration").toLocalTime());
            	activity.setAverageRhythm(rs.getTime("AverageRhythm").toLocalTime());
            	activity.setCdate(rs.getDate("CDate").toLocalDate());
            	list.add(activity);
            } 
            else list = null;
		}
		catch(SQLException e) {
			//TODO: Manage especific exceptions
			e.getStackTrace();
    		list = null;
        }		
		return list;
	}
}