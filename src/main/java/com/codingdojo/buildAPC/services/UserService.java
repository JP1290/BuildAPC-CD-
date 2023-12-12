package com.codingdojo.buildAPC.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.buildAPC.models.Login;
import com.codingdojo.buildAPC.models.User;
import com.codingdojo.buildAPC.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> newerUser = userRepo.findByEmail(newUser.getEmail());
		
		if(newerUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email is already in use");
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords do not match");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return userRepo.save(newUser);
	}
	
	public User login(Login newLogin, BindingResult result) {
		
		Optional<User> loggedUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!loggedUser.isPresent()) {
			result.rejectValue("email", "Matches", "Incorrect Email");
			return null;
		}
		
		User user = loggedUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Incorrect Password");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		return user;
	}
	
	public User findById(Long id) {
		
		Optional<User> userId = userRepo.findById(id);
		
		if(userId.isPresent()) {
			return userId.get();
		}
		
		return null;
	}
	
	
}
