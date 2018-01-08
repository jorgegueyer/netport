package com.jgy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkers {
	
	public static boolean checkEmail(String email) {
		if (email == null || email.length() == 0)
			return false;
		else {
			Pattern pat = Pattern.compile("/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/");
		    Matcher mat = pat.matcher(email);
		    if (mat.matches())
		    	return true;
		    else return false;
		}		
	}
	
	public static boolean verifyEnterPasword(String password,String password_confirmation) {
		if (password == null || password.isEmpty() || password_confirmation == null || password_confirmation.isEmpty()) {
			return false;
		}	
		else if (password.compareTo(password_confirmation) == 0 ){
				return true;
		}		
		else return false;
	}
}
