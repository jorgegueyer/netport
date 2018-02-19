package com.jgy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkers {
	
	//private static final String EMAIL_PATTERN = "/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/";
	private static final String EMAIL_PATTERN = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
	private static final String PASSWORD_PATTERN = "[0-9A-Za-z]{6}";
	private static final String USERNAME_PATTERN = "[0-9A-Za-z]{1,15}";
	private static final int MAX_LENGTH_EMAIL = 35;
	private static final int MAX_LENGTH_USERNAME = 15;
	private static final int MAX_LENGTH_PASSWORD = 6;
	
	
	public static boolean checkEmail(String email) {
		if (email == null || email.isEmpty() || email.length() > MAX_LENGTH_EMAIL)
			return false;
		else {
			
			Pattern pat = Pattern.compile(EMAIL_PATTERN);
		    Matcher mat = pat.matcher(email);
		    if (mat.matches()) {
		    	return true;
		    }	
		    else return false;
		}		
	}
	
	public static boolean checkUsername(String username) {
		if (username == null || username.isEmpty() || username.length() > MAX_LENGTH_USERNAME)
			return false;
		else {
			if (username.indexOf("@") >= 0) {
				return checkEmail(username);
			}
			else {
				Pattern pat = Pattern.compile(USERNAME_PATTERN);
			    Matcher mat = pat.matcher(username);
			    if (mat.matches()) {
			    	return true;
			    }			    	
			    else return false;
			}
		}		
	}
	
	public static boolean checkPassword(String password) {
		if (password == null || password.isEmpty() || password.length() > MAX_LENGTH_PASSWORD)
			return false;
		else {
			Pattern pat = Pattern.compile(PASSWORD_PATTERN);
		    Matcher mat = pat.matcher(password);
		    if (mat.matches())
		    	return true;
		    else return false;
		}		
	}
	
	public static boolean verifyEnteredPaswords(String password,String password_confirmation) {
		if (!checkPassword(password) || !checkPassword(password_confirmation)) {
			return false;
		}	
		else if (password.compareTo(password_confirmation) == 0 ){
				return true;
		}		
		else return false;
	}
	
	public static boolean verifyDate(String date) {
		if (date == null || date.isEmpty()) {
			return false;
		}	
		else if (Parsers.parserStringtoLocalDate(date) != null){
				return true;
		}		
		else return false;
	}
}
