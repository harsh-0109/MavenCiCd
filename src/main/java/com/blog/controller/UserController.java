package com.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.User;
import com.blog.exception.UserAlreadyPresentException;
import com.blog.repositories.UserRepository;
import com.blog.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserServiceImpl service;

	public UserController (UserServiceImpl service) {
		this.service = service;
	}
	
	@PostMapping("/addUser")
	public String createUser(@RequestBody User user) throws UserAlreadyPresentException
	{
		String s = null;
		int status = service.createUser(user);
		if(status == 1)
		{
			throw new UserAlreadyPresentException("User already Exists with id " +user.getId());
		}
		else {
			 s = "User created Successfully";		
			}
		return s;
	}
	
	

}
