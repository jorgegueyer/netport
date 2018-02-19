package com.jgy.utils;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	
	public static String getUrlPattern(HttpServletRequest request) {
		
		ServletContext servletContext = request.getServletContext();
	    String servletPath = request.getServletPath();
	    String pathInfo = request.getPathInfo();
	    
	    //http://localhost:8080/contextPath/servletPath/pathInfo?queryString
	    //http://localhost:8080/  noetport /   home   / account ?   p1=1
	 
	    String urlPattern = null;
	    if (pathInfo != null) {
	    	urlPattern = servletPath + "/*";
	        return urlPattern;
	    }
	    urlPattern = servletPath;
	 
	    boolean has = hasUrlPattern(servletContext, urlPattern);
	    if (has) {
	    	return urlPattern;
	    }	    
	    return "/";
	}	
	
	private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {
		 
		Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();
	 
	    for (String servletName : map.keySet()) {
	    	ServletRegistration sr = map.get(servletName);	 
	        Collection<String> mappings = sr.getMappings();
	        if (mappings.contains(urlPattern)) {
	        	return true;
	        }	 
	    }
	    return false;
	}
}
