package com.jgy.dao.objects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jgy.dao.DBConn;
import com.jgy.dao.interfaces.ILoginDAO;
import com.jgy.dao.to.LoginTO;

/**
 * 
 * DAO to obtain data from the Login table	
 * @author Jorge Guerra Yerpes 
 * 
 */
public class LoginDAO implements ILoginDAO {
	
	public LoginTO findLogin(String username, String password) throws SQLException {
		
		LoginTO login = null;		
		String query  = "SELECT * FROM Login ";
		query += "WHERE (Username='" + username + "' OR Email='" + username + "') AND Password='" + password + "'";
		
		try (
				Connection conn = DBConn.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
		) {
			
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
        	//TODO: Manage especific exceptions
        	e.getStackTrace();
    		login = null;
        }		
		return login;
	}	
	
	public boolean existLogin(String username, String email) throws SQLException {
		
		String query  = "SELECT * FROM Login ";
		query += "WHERE (Username='" + username + "' OR Email='" + email + "')";
		
		try (
				Connection conn = DBConn.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
		) {
			
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return true;
            else return false;
		}
        catch (SQLException e) {	
        	//TODO: Manage especific exceptions
        	e.getStackTrace();
        }		
		return false;
	}
	
	@Override	
	public LoginTO insertLogin(LoginTO login) throws SQLException {
		
		LoginTO result = null;
		String query  = "INSERT INTO Login (Userid, Username, Email, Password)";
		query += "VALUES(";
		query += "'" + login.getUserID()	+ "',"; 
		query += "'" + login.getUsername()  + "',";
		query += "'" + login.getEmail()    	+ "',";
		query += "'" + login.getPassword() 	+ "')";
		
		//TODO: Change the way to access to BBDD
		try (
				Connection conn = DBConn.getInstance().getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);				
		) {			
			
	        int rowsAffected = stmt.executeUpdate();	        
	        if (rowsAffected == 0) {
	        	result = null;	
	        }
	        else {
	        	result = login;
	        }	        
		}    
	    catch(SQLException ex) {
	    	//TODO: Manage especific exceptions
	    	result = null;
	    }		
		return result; 
	}	
}