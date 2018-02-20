package com.jgy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jgy.config.Pages;
import com.jgy.dao.to.ActivityTO;
import com.jgy.dao.to.LoginTO;
import com.jgy.facade.ActivityFacade;

/**
 * 
 * Controller to load the main user page with its information	
 * @author Jorge Guerra Yerpes 
 * 
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	LoginTO login = (LoginTO) session.getAttribute("login");
    	
    	ActivityFacade facade = new ActivityFacade();
    	List<ActivityTO> list = null;
    	try {
    		list = facade.getActivitiesByUser(login.getUserID());
    	}
    	catch(SQLException e) {
    		System.out.println(e.getStackTrace());
    		list = null;
    	}
    	if (list == null) {
    		//TODO: Change empty data message
    		request.setAttribute("message","It hasn't been possible to load the data");
    	}
    	else {
    		request.setAttribute("list",list);
    	}
    	
    	request.setAttribute("nav",Pages.JSPNAVHOME);
    	request.setAttribute("page",Pages.JSPHOME);
    	request.getRequestDispatcher(Pages.JSPTEMPLATE).forward(request, response);       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
