package com.jgy.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * DBConn creates the data source and offers access the connections pool to the BBDD	
 * @author Jorge Guerra Yerpes 
 * 
 */
public class DBConn {
	
	private static final String JDBC_RESOURCE_NAME = "jdbc/netport";

	private static DataSource ds;
	private static Connection conn;
	private static DBConn instance = null;
    
    protected DBConn() {    	
    	Context initCtxt;
    	Context envCtxt;
		try {
			initCtxt = new InitialContext();
			envCtxt = (Context) initCtxt.lookup("java:comp/env");
			ds = (DataSource) envCtxt.lookup(JDBC_RESOURCE_NAME);
		} catch (NamingException e) {
			// TODO: Manage exceptions by accesing BBDD
			e.printStackTrace();
		}		
    }
    
    
    public static DBConn getInstance(){
    	if (instance == null) {
    		instance = new DBConn();
    	}
        return instance;
    }
	
	public Connection getConnection() {	
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO: Manage exceptions by accesing BBDD
			e.printStackTrace();
			conn = null;
		}		
	    return conn;
	}
}
