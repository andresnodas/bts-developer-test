package intersolusi.teknologi.asia.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fasterxml.jackson.core.JsonProcessingException;

import intersolusi.teknologi.asia.model.request.SignInRequest;
import intersolusi.teknologi.asia.model.request.UserRequest;
import intersolusi.teknologi.asia.model.response.SignInResponse;
import intersolusi.teknologi.asia.model.response.UserResponse;

public interface UserService extends UserDetailsService {

	List<UserResponse> getUsers();
	
	SignInResponse userSignUp(UserRequest request) throws JsonProcessingException;
	
	SignInResponse userSignIn(SignInRequest request) throws JsonProcessingException;
	
}
