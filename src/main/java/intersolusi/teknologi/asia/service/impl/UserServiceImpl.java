package intersolusi.teknologi.asia.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import intersolusi.teknologi.asia.SpringAppContext;
import intersolusi.teknologi.asia.entity.User;
import intersolusi.teknologi.asia.model.request.SignInRequest;
import intersolusi.teknologi.asia.model.request.UserRequest;
import intersolusi.teknologi.asia.model.response.SignInResponse;
import intersolusi.teknologi.asia.model.response.UserResponse;
import intersolusi.teknologi.asia.repository.UserRepository;
import intersolusi.teknologi.asia.service.UserService;
import intersolusi.teknologi.asia.utils.JwtHelper;
import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public List<UserResponse> getUsers() {
		
		List<UserResponse> responses = new ArrayList<>();
		
		List<User> users = userRepository.findAll();
		
		responses.addAll(users.stream()
				.map(user -> {
					UserResponse response = new UserResponse();
					BeanUtils.copyProperties(user, response);
					
					return response;
				}).collect(Collectors.toList()));
		
		return responses;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email).orElseThrow(() -> {
			throw new UsernameNotFoundException("Email " + email + " not found !");
		});
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

	@Override
	public SignInResponse userSignUp(UserRequest request) throws JsonProcessingException {

		User user = new User();
		BeanUtils.copyProperties(request.getUser(), user);
		
		user.setPassword(bCryptPasswordEncoder.encode(request.getUser().getPassword()));
		
		User storedUser = userRepository.save(user);
		
		return createSignInResponse(storedUser);
	}

	@Override
	public SignInResponse userSignIn(SignInRequest request) throws JsonProcessingException {
		
		AuthenticationManager authenticationManager = SpringAppContext.getBean(AuthenticationManager.class);
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> {
			throw new UsernameNotFoundException("Email " + request.getEmail() + " not found !");
		});
		
		return createSignInResponse(user);
	}
	
	private SignInResponse createSignInResponse(User user) throws JsonProcessingException {
		
		ObjectMapper mapper = SpringAppContext.getBean(ObjectMapper.class);
		SignInResponse response = new SignInResponse();
		
		response.setEmail(user.getEmail());
		response.setUsername(user.getUsername());
		
		String token = JwtHelper.createToken(mapper.writeValueAsString(user.getEmail()));
		response.setToken(token);
		
		return response;
	}


}
