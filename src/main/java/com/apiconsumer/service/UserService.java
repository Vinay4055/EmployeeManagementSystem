package com.apiconsumer.service;

import org.springframework.stereotype.Service;

import com.apiconsumer.entity.User;
@Service
public interface UserService {
	public User findByUserId(String id);
	public boolean registerUser(User user);
}
