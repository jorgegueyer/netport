package com.jgy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jgy.config.Pages;
import com.jgy.dao.to.LoginTO;
import com.jgy.facade.LoginFacade;
import com.jgy.utils.Checkers;

@WebServlet(name = "Session", urlPatterns = {"/session"})
public class Session extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String error;
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		LoginTO login = null;
		this.error = null;
		if (this.processParametersForm(request)) {		 
			
			LoginFacade facade = new LoginFacade();
			try {
				login = facade.login(this.username, this.password);
			}
			catch(SQLException e) {
				System.out.println(e.getStackTrace());
				login = null;
			}
			if (login == null) { 
				this.error = "The username or the password isn't correct! Please, try it again!";
			}	
		}	
		if (this.error == null && login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			response.sendRedirect(request.getContextPath() + Pages.HOME);
		}		
		else if (this.error != null){
			request.setAttribute("error",this.error);	
			request.setAttribute("page",Pages.JSPLOGIN);	
			request.getRequestDispatcher(Pages.JSPTEMPLATE).forward(request, response);
		}
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.sendError(401,"Acceso denegado");//TODO Gestión de errores a mostrar al usuario
    }
    
    private boolean processParametersForm(HttpServletRequest request) {    	
		this.username = (String)request.getParameter("username");
		this.password = (String)request.getParameter("password");	
		return this.validatorParameter();
		
    }
    
    private boolean validatorParameter() {
    	try {    		
			if (!Checkers.checkUsername(this.username) || !Checkers.checkPassword(password)) 
				throw new NullPointerException("Required email or username valid, and its password!");			
    	}
		catch(NullPointerException e) {
			this.error = e.getMessage();
			return false;
		}
    	return true;
    }
}
