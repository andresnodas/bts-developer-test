package intersolusi.teknologi.asia.security;

import intersolusi.teknologi.asia.SpringAppContext;

public class SecurityConstants {

	public static final long EXPIRATION_TIME = 864000000; //in milisecond 10days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGNIN_URL = "/users/signin";
	public static final String SIGNUP_URL = "/users/signup";
	
	public static String getTokenSecret() {
		AppProperties appProperties = SpringAppContext.getBean(AppProperties.class);
		
		return appProperties.getTokenSecret();
	}
	
}
