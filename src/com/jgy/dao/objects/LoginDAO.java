package com.jgy.dao.objects;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jgy.dao.DBConn;
import com.jgy.dao.interfaces.ILoginDAO;
import com.jgy.dao.to.LoginTO;


public class LoginDAO implements ILoginDAO {
	
	public LoginTO findLogin(String username, String password) throws SQLException {
		LoginTO login = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBConn.getInstance().getConnection();	
			
			String query  = "SELECT * FROM Login ";
			query += "WHERE (Username='" + username + "' OR Email='" + username + "') AND Password='" + Integer.parseInt(password) + "'";
			
			stmt = conn.prepareStatement(query);
			
            ResultSet rs = stmt.executeQuery();
            
            login = new LoginTO();
            
            if (rs.next()) {
            	login.setUserID(rs.getInt("Userid"));
            	login.setUsername(rs.getString("Username"));
            	login.setEmail(rs.getString("Email"));
            	login.setPassword(rs.getString("Password"));
            } 
            else login = null;
		}
        catch (SQLException e) {	
        	//TODO: Manejar excepciones de la búsqueda de Login
        	e.getStackTrace();
    		login = null;
        }
		finally{			
			if (stmt != null) stmt.close();
        	if (conn != null) conn.close();
    	} 
		return login;
	}	
	
	@Override	
	public LoginTO insertLogin(LoginTO login) throws SQLException {
		LoginTO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {			
			conn = DBConn.getInstance().getConnection();	
			
			String query  = "INSERT INTO Login (Userid, Username, Email, Password)";
			query += "VALUES(";
			query += "'" + login.getUserID()	+ "',"; 
			query += "'" + login.getUsername()  + "',";
			query += "'" + login.getEmail()    	+ "',";
			query += "'" + login.getPassword() 	+ "')";
			
			stmt = conn.prepareStatement(query);
			
	        int rowsAffected = stmt.executeUpdate();
	        
	        if (rowsAffected == 0) {
	        	result = null;	
	        }
	        else {
	        	result = login;
	        }	        
		}    
	    catch(SQLException ex) {
	    	//TODO: Manejar excepciones de la creación de un Login
	    	result = null;
	    }
		finally {
			if (stmt != null) stmt.close();
        	if (conn != null) conn.close();
        }
		return result; 
	}	
}