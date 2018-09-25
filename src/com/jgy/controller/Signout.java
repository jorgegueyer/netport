package com.jgy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jgy.config.Pages;

/**
 * 
 * Controller to close the session	
 * @author Jorge Guerra Yerpes 
 * 
 */
@WebServlet(name = "Signout", urlPatterns = {"/signout"})
public class Signout extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
				 
		HttpSession session = request.getSession(false);
	    if(session != null) {
	    	session.removeAttribute("login");	    	
            session.invalidate();
            session = null;
        }		
		
		request.setAttribute("nav", Pages.JSP_NAV_LOGIN);
		request.setAttribute("page", Pages.JSP_SIGNOUT);
    	request.getRequestDispatcher(Pages.JSP_TEMPLATE).forward(request, response);       
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
