package com.jgy.config;

import java.util.ArrayList;
import java.util.List;

public class SessionConfig {
	private static final String HOME = "/home";
	private static final String SESSION = "/session";
	private static final String PRESIGNUP = "/presignup";
	private static final String POSTSIGNUP = "/postsignup";	
	private static final List<String> pathConfig = new ArrayList<String>();
	
	static {
        init();
    }
	
	private static void init() {
		pathConfig.add(HOME);
		pathConfig.add(SESSION);
		pathConfig.add(PRESIGNUP);
		pathConfig.add(POSTSIGNUP);
	}

	public static List<String> getUrlPatterns() {
		return pathConfig;
	}
}
	