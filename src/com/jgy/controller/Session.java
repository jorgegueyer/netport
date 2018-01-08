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

@WebServlet(name = "Session", urlPatterns = {"/sessions"})
public class Session extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String error;
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {		
		
		LoginTO login = null;
		this.error = null;
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
	 
		if (Checkers.checkEmail(email) || password == null || password.length() == 0) {
			error = "Required username and password!";			
		}
		else {
				LoginFacade facade = new LoginFacade();
				try {
					login = facade.login(email, password);
				}
				catch(SQLException e) {
					System.out.println(e.getStackTrace());
					login = null;
				}
				if (login == null) { 
					this.error = "The username o the password isn't correct! Please, try it again!";
				}	
		} 
		
		if (this.error == null && login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			response.sendRedirect(request.getContextPath() + Pages.HOME);
			//request.getRequestDispatcher(Pages.HOME).forward(request, response);
		}
		else {
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
}
