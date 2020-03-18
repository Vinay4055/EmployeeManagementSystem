package com.apiconsumer.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apiconsumer.entity.User;
import com.apiconsumer.repository.UserRepository;
import com.apiconsumer.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUserId(String id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} 
		else
			return null;

	}

	public boolean registerUser(User user) {
		User foundUser = findByUserId(user.getId());
		if (foundUser == null) {

			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			return true;
		}
		return false;
	}

	

}
