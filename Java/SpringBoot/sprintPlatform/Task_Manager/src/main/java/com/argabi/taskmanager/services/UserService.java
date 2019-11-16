package com.argabi.taskmanager.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.argabi.taskmanager.models.Task;
import com.argabi.taskmanager.models.User;
import com.argabi.taskmanager.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 public UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder)     {
	        this.userRepository = userRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }
	 
	 
	 //1 Register a new User
	 public void userRegistration(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        userRepository.save(user);
	    }
	 
	
	 public User findByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
	 
	 //all Users
	//get all tasks
		public List<User> getAllUsers() {
			return userRepository.findAll();
		}
}
