package com.blog.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepo = userRepository;
	}

	@Override
	public int createUser(User user) {
		int status = 0;
		int id = user.getId();
		Optional<User> byId = userRepo.findById(id);
		boolean present = byId.isPresent();
		if (present) {
			status = 1;
		} else {
			userRepo.save(user);
			status = 2;
		}
		return status;
	}
	
	

	

}
