package com.jgy.controller;

import java.io.IOException;
import java.sql.Date;
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
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		this.error = null;
		getParametersForm(request);
		if (!this.validatorParameter()) {
			request.setAttribute("error", this.error);
			request.setAttribute("page", Pages.JSPSIGNUP);
		}
		else {
			UserTO user = new UserTO();		
			LoginTO login = new LoginTO();
			login.setUsername(username);
			user.setName(name);
			user.setSurname(surname);
			login.setEmail(email);
			user.setBirthday(Date.valueOf(birthday)); 			
			login.setPassword(password);
			
			UserFacade userFacade = new UserFacade();
			LoginFacade loginFacade = new LoginFacade();			
			try {
				user = userFacade.createUser(user);							
				if (user != null) {
					login = loginFacade.createLogin(login);				
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				login = null;
				user = null;
			}
			if (user != null && login != null) {
				request.setAttribute("success", "Usuario creado correctamente! Por favor inicie sesión.");
				request.setAttribute("page", Pages.JSPLOGIN);
			}	
			else if (user == null || login == null){
				//TODO: Gestión de errores para problemas especificos
				request.setAttribute("error", "No se ha podido crear la cuenta");
				request.setAttribute("page", Pages.JSPSIGNUP);				
			}
		}
    	request.getRequestDispatcher(Pages.JSPTEMPLATE).forward(request, response);       
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }	
    
    private void getParametersForm(HttpServletRequest request) {    	
		name 					= (String)request.getParameter("name");
		surname 				= (String)request.getParameter("surname");
		birthday 				= (String)request.getParameter("birhday");
		username 				= (String)request.getParameter("username");
		email 					= (String)request.getParameter("email");
		password 				= (String)request.getParameter("password");		
		password_confirmation 	= (String)request.getParameter("password_confirmation");
    }
    
    private boolean validatorParameter() {
    	try {
			if (username == null) throw new NullPointerException();			
			if (name == null) throw new NullPointerException("Please, all fields must be filled in!");			
			if (surname == null) throw new NullPointerException("Please, all fields must be filled in!");			
			if (birthday == null) throw new NullPointerException("Please, all fields must be filled in!"); //TODO: Check a valid date			
			if (!Checkers.checkEmail(email)) throw new NullPointerException("Please, you must enter a property email!");			
			if(!Checkers.verifyEnterPasword(password, password_confirmation)) throw new NullPointerException("Please, you must enter a property email!");
    	}
		catch(NullPointerException e) {
			this.error = e.getMessage();
			return false;
		}
    	return true;
    }
}