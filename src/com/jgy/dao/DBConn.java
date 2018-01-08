package com.jgy.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {
	
	private static final String JDBCRESOURCENAME = "jdbc/netport";

	private static DataSource ds;
	private static Connection conn;
	private static DBConn instance = null;
    
    protected DBConn() {    	
    	Context initCtxt;
    	Context envCtxt;
		try {
			initCtxt = new InitialContext();
			envCtxt = (Context) initCtxt.lookup("java:comp/env");
			ds = (DataSource) envCtxt.lookup(JDBCRESOURCENAME);
		} catch (NamingException e) {
			// TODO: Gestionar Excepciones de acceso a BBDD
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
			// TODO: Gestionar Excepciones de acceso a BBDD
			e.printStackTrace();
			conn = null;
		}		
	    return conn;
	}
}
