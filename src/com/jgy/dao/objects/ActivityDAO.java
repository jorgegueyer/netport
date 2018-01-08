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

public class ActivityDAO implements IActivityDAO {
	
	public List<ActivityTO> findActivitiesByUser(int userid) throws SQLException {
		List<ActivityTO> list = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBConn.getInstance().getConnection();	
			
			String query  = "SELECT * FROM Activity ";
			query += "WHERE Userid='" + userid + "'";
			
			stmt = conn.prepareStatement(query);
			
            ResultSet rs = stmt.executeQuery();
            
            list = new ArrayList<ActivityTO>();            
            
            if (rs.next()) {
            	ActivityTO activity = new ActivityTO();
            	activity.setUserid(rs.getInt("Userid"));
            	activity.setName(rs.getString("Name"));
            	activity.setType(rs.getString("Type"));
            	activity.setDuration(rs.getTime("Duration"));
            	activity.setAverageRhythm(rs.getTime("AverageRhythm"));
            	activity.setCdate(rs.getDate("CDate"));
            	list.add(activity);
            } 
            else list = null;
		}
		catch(SQLException e) {
			//TODO: Manejar excepciones de la búsqueda de actividades
			e.getStackTrace();
    		list = null;
        }
		finally{
			if (stmt != null) stmt.close();
        	if (conn != null) conn.close();
    	} 
		return list;
	}
}