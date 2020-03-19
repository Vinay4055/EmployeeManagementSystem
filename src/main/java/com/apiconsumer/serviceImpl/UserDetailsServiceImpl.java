package com.apiconsumer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apiconsumer.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		
		UserBuilder builder;
		com.apiconsumer.entity.User user = userService.findByUserId(userName);
		if (user != null) {
			builder = User.withUsername(userName);
			builder.password(user.getPassword());
			builder.roles("user");
			
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}
