package com.jgy.dao.objects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jgy.dao.DBConn;
import com.jgy.dao.interfaces.IUserDAO;
import com.jgy.dao.to.UserTO;
import com.jgy.utils.Parsers;

/**
 * 
 * DAO to obtain data from the User table	
 * @author Jorge Guerra Yerpes 
 * 
 */
public class UserDAO implements IUserDAO  {
	
	@Override
	public UserTO findUserById(int userid) throws SQLException {
		
		UserTO user = null;
		if (userid > 0) { 
			
			String query  = "SELECT * FROM User";
        	query += "WHERE ID='" + userid + "'";
			
			try (
					Connection conn = DBConn.getInstance().getConnection();
					PreparedStatement stmt = conn.prepareStatement(query);
			) {
	            	
            	ResultSet rs = stmt.executeQuery();            	
            	user = new UserTO();  
            	
    			if (rs.next()) {
    				user.setId(rs.getInt("ID"));
                	user.setName(rs.getString("Name"));
                	user.setSurname(rs.getString("Surname"));
                	user.setBirthday(Parsers.parserDatetoLocalDate(rs.getDate("Birthday")));
                }
	        }			
			catch (SQLException e) {	
				//TODO: Manage especific exceptions
				e.getStackTrace();
				user = null;
			}
		}
		return user;
	}	
		
	@Override	
	public UserTO insertUser(UserTO user)  throws SQLException {
		
		UserTO result = null;
		String query = "INSERT INTO User (Name, Surname, Birthday)";
		query +="VALUES(";
		query += "'" + user.getName()  		+ "',"; 
		query += "'" + user.getSurname()    + "',"; 
		query += "'" + user.getBirthday().toString()	+ "')";
		
		try (
				Connection conn = DBConn.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);				
		) {
			
			int rowsAffected = stmt.executeUpdate();	        
	        if (rowsAffected == 0) {
	        	result = null;	
	        }
	        else {        	
		       	ResultSet rs = stmt.getGeneratedKeys();
		        if (rs.next()) { 
		        	int id = rs.getInt(1);
		        	if (id > 0) {
		        		user.setId(id);
		        		result = user;
		        	}
		        }
	        }
		}    
	    catch(SQLException ex) {
	    	//TODO: Manage especific exceptions	    	
	    	result = null;
	    }		
		return result; 
	}	

// TODO : it will be developed	
//	@Override
//	public String updateUser(UserTO user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//  TODO : it will be developed
//	@Override
//	public String removeUser(Integer idUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}	
}