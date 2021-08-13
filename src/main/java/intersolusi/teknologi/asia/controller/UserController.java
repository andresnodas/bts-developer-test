package intersolusi.teknologi.asia.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import intersolusi.teknologi.asia.model.request.SignInRequest;
import intersolusi.teknologi.asia.model.request.UserRequest;
import intersolusi.teknologi.asia.model.response.SignInResponse;
import intersolusi.teknologi.asia.model.response.UserResponse;
import intersolusi.teknologi.asia.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {

	private UserService userService;
	
	@GetMapping
	public List<UserResponse> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SignInResponse userSignUp(@RequestBody UserRequest request) throws JsonProcessingException {
		return userService.userSignUp(request);
	}
	
	@PostMapping(path = "/signin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SignInResponse userSignIn(@RequestBody SignInRequest request) throws JsonProcessingException {
		return userService.userSignIn(request);
	}
	
}
