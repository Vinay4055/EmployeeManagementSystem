package com.apiconsumer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apiconsumer.model.User;
import com.apiconsumer.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private User user;

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping(value = "/register")
	public String registerUser(@Valid User user, HttpServletRequest request, Model map, BindingResult result) {

		if (result.hasErrors()) {

			return "redirect:/login";
		}

		else if (userService.registerUser(user.userModelToUserEntity(user))) {

			map.addAttribute("message", "Successfully registered user");
			return "redirect:/login";
		} else {
			map.addAttribute("message", "User already exists");
			return "register";
		}
	}


}
