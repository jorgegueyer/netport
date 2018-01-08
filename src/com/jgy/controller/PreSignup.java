package com.jgy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgy.config.Pages;

@WebServlet(name = "PreSignup", urlPatterns = {"/presignup"})
public class PreSignup extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
		request.setAttribute("page", Pages.JSPSIGNUP);
    	request.getRequestDispatcher(Pages.JSPTEMPLATE).forward(request, response);       
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }	
}