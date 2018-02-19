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

public class UserDAO implements IUserDAO  {
	
	@Override
	public UserTO findUserById(int userid) throws SQLException{
		UserTO user = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//TODO: Forma insegura de obtener la conexión
			conn = DBConn.getInstance().getConnection();	
			
            if (userid > 0) {            	
            	String query  = "SELECT * FROM User";
            	query += "WHERE ID='" + userid + "'";
    			
            	stmt = conn.prepareStatement(query);
            	
            	ResultSet rs = stmt.executeQuery();
            	
            	user = new UserTO();
    			
    			if (rs.next()) {
    				user.setId(rs.getInt("ID"));
                	user.setName(rs.getString("Name"));
                	user.setSurname(rs.getString("Surname"));
                	user.setBirthday(Parsers.parserDatetoLocalDate(rs.getDate("Birthday")));
                }
    			else user = null;
            }
		}
		catch (SQLException e) {	
			//TODO: Manejar excepciones de la búsqueda de User
			e.getStackTrace();
			user = null;
		}			
        finally{
        	if (stmt != null) stmt.close();
        	if (conn != null) conn.close();
        }
		return user;
	}	
		
	@Override	
	public UserTO insertUser(UserTO user)  throws SQLException {
		UserTO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {			
			conn = DBConn.getInstance().getConnection();	
			
			String query = "INSERT INTO User (Name, Surname, Birthday)";
			query +="VALUES(";
			query += "'" + user.getName()  		+ "',"; 
			query += "'" + user.getSurname()    + "',"; 
			query += "'" + user.getBirthday().toString()	+ "')";
			
			stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
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
	    	//TODO: Manejar excepciones de la creación de un User
	    	
	    	result = null;
	    }
		finally {
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
        }
		return result; 
	}	

// TODO : Se Implementará método cuando avance el desarrollo	
//	@Override
//	public String updateUser(UserTO user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//  TODO : Se Implementará método cuando avance el desarrollo
//	@Override
//	public String removeUser(Integer idUser) {
//		// TODO Auto-generated method stub
//		return null;
//	}	
}