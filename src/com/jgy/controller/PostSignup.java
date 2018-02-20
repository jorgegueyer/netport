package com.jgy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jgy.config.Pages;
import com.jgy.dao.to.LoginTO;
import com.jgy.dao.to.UserTO;
import com.jgy.facade.LoginFacade;
import com.jgy.facade.UserFacade;
import com.jgy.utils.Checkers;
import com.jgy.utils.Parsers;

/**
 * 
 * Controller to process the data after Signing up	
 * @author Jorge Guerra Yerpes 
 * 
 */
@WebServlet(name = "PostSignup", urlPatterns = {"/postsignup"})
public class PostSignup extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	
	private String error;
	private String username;
	private String name;
	private String surname;
	private String birthday;
	private String email;
	private String password;
	private String password_confirmation;
	
	//TODO: Check logic
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		
		this.error = null;
		if (!this.processParametersForm(request)) {
			request.setAttribute("error", this.error);
			request.setAttribute("page", Pages.JSPSIGNUP);
		}
		else {
			UserTO user = new UserTO();		
			LoginTO login = new LoginTO();
			login.setUsername(this.username);
			user.setName(this.name);
			user.setSurname(this.surname);
			login.setEmail(this.email);
			user.setBirthday(Parsers.parserStringtoLocalDate(this.birthday)); 			
			login.setPassword(this.password);
			
			UserFacade userFacade = new UserFacade();
			LoginFacade loginFacade = new LoginFacade();			
			try {
				if (!loginFacade.searchlogin(this.username, this.email)) {
					user = userFacade.createUser(user);							
					if (user != null) {
						login.setUserID(user.getId());
						login = loginFacade.createLogin(login);				
					}
				} else {
					this.error = "It already exists an account with these credentials!";
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				login = null;
				user = null;
				this.error = "No se ha podido crear la cuenta";
			}
			if (this.error != null){
				//TODO: Manage specific problems
				request.setAttribute("error", this.error);
				request.setAttribute("nav", Pages.JSPNAVLOGIN);
				request.setAttribute("page", Pages.JSPSIGNUP);				
			}
			else if (user != null && login != null) {
				request.setAttribute("success", "User created properly! Sign in, please.");
				request.setAttribute("nav", Pages.JSPNAVLOGIN);
		    	request.setAttribute("page", Pages.JSPLOGIN);
			}	
			
		}
    	request.getRequestDispatcher(Pages.JSPTEMPLATE).forward(request, response);       
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }	
    
    private boolean processParametersForm(HttpServletRequest request) {    	
		this.name 					= (String)request.getParameter("name");
		this.surname 				= (String)request.getParameter("surname");
		this.birthday 				= (String)request.getParameter("birthday");
		this.username 				= (String)request.getParameter("username");
		this.email 					= (String)request.getParameter("email");
		this.password 				= (String)request.getParameter("password");		
		this.password_confirmation 	= (String)request.getParameter("password_confirmation");
		return this.validatorParameter();
    }
    
    private boolean validatorParameter() {
    	try {
			if (!Checkers.checkUsername(this.username)) throw new NullPointerException("Please, all fields must be filled in properly");			
			if (this.name == null) throw new NullPointerException("Please, all fields must be filled in properly!");			
			if (this.surname == null) throw new NullPointerException("Please, all fields must be filled in properly!");			
			if (!Checkers.verifyDate(this.birthday)) throw new NullPointerException("Please, all fields must be filled in properly!");	
			if (!Checkers.checkEmail(this.email)) throw new NullPointerException("Please, you must enter a property email properly!");			
			if (!Checkers.verifyEnteredPaswords(this.password,this.password_confirmation)) throw new NullPointerException("Please, you must enter a property email properly!");
    	}
		catch(NullPointerException e) {
			this.error = e.getMessage();
			return false;
		}
    	return true;
    }
}