package com.jgy.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jgy.config.Pages;
import com.jgy.config.SessionConfig;
import com.jgy.dao.to.LoginTO;
import com.jgy.utils.SessionUtils;

@WebFilter("/*")
public class SessionFilter implements Filter {	
 
    public SessionFilter() {
    }
    
    @Override
    public void init(FilterConfig fConfig) throws ServletException { 
    }
 
    @Override
    public void destroy() {
    }
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
    	
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
 
        String servletPath = request.getServletPath();
        
        HttpSession session = request.getSession();
    	LoginTO login = (LoginTO) session.getAttribute("login");
 
        if (servletPath.equals(Pages.LOGIN) || servletPath.equals(Pages.PRESIGNUP)) {
            chain.doFilter(request, response);
            return;
        }
        
        HttpServletRequest wrapRequest = request;
 
        if (!this.isSessionPage(request) || login == null) {         	
        	response.sendRedirect(request.getContextPath() + Pages.LOGIN);
            return;
        }
 
        chain.doFilter(wrapRequest, response);
    }
    
    private boolean isSessionPage(HttpServletRequest request) {    	
        String urlPattern = SessionUtils.getUrlPattern(request);
        List<String> urlPatterns = SessionConfig.getUrlPatterns();
        if (urlPatterns != null && urlPatterns.contains(urlPattern)) {
        	return true;
        }
        return false;
    }
}