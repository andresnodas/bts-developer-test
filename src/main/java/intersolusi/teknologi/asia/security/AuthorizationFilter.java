package intersolusi.teknologi.asia.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import intersolusi.teknologi.asia.utils.JwtHelper;

public class AuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getTokenHeader(request);
		
		if(token == null ||
			(token != null && token.trim().equals(""))) {
			filterChain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		filterChain.doFilter(request, response);
	}
	
	private String getTokenHeader(HttpServletRequest request) {
		
		String header = request.getHeader(SecurityConstants.HEADER_STRING);
		
		if(header != null && header.startsWith(SecurityConstants.TOKEN_PREFIX))
			return header.replace(SecurityConstants.TOKEN_PREFIX, "");
		
		return "";
	}
	
	private UsernamePasswordAuthenticationToken getAuthentication(String token) throws JsonMappingException, JsonProcessingException {
		String subject = JwtHelper.getSubject(token);
		return new UsernamePasswordAuthenticationToken(subject, null, new ArrayList<>());
	}

}
