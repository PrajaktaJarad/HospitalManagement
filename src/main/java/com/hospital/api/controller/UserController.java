package com.hospital.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.api.model.User;
import com.hospital.api.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
}
