package com.jgy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgy.config.Pages;

/**
 * 
 * Controller to load the Sign up page	
 * @author Jorge Guerra Yerpes 
 * 
 */
@WebServlet(name = "PreSignup", urlPatterns = {"/presignup"})
public class PreSignup extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		request.setAttribute("nav", Pages.JSP_NAV_LOGIN);
		request.setAttribute("page", Pages.JSP_SIGNUP);
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