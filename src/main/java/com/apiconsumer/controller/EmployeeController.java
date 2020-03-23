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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apiconsumer.common.LoggedUser;
import com.apiconsumer.model.Employee;
import com.apiconsumer.repository.UserRepository;
import com.apiconsumer.service.RestService;

@Controller
@RequestMapping("/employeeManagement")
public class EmployeeController {
	@Autowired
	private RestService restService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Employee employee;

	@PostMapping(value = "/")
	public String listAllEmployees(Model model) {
		model.addAttribute("employees", restService.getAllEmployees());
		String id = LoggedUser.loggedInUser();
		String name = userRepository.findById(id).get().getName(); //Call it from service 
		model.addAttribute("userName", name);
		return "listAllEmployees";

	}

	@GetMapping(value = "/editEmployee")
	public String editEmployee(@RequestParam("code") int employeeCode, Model map) { //Send code from model 
		Employee employee = restService.getByEmployeeCode(employeeCode); 
		map.addAttribute("employee", employee);
		return "editEmployee";
	}

	@PostMapping(value = "/editEmployee")
	public String editEmployee(@ModelAttribute("employee")Employee employee) {
		restService.addEmployee(employee);
		return "forward:/employeeManagement/";
	}

	@PostMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model map) {
		
		map.addAttribute("employee", employee);
		
		return "insertEmployee";
	}
	@PostMapping("/addEmployee")
	public String addEmployee(@Valid@ModelAttribute("employee")Employee employee) {
		
		restService.addEmployee(employee);
		
		return "forward:/employeeManagement/";
	}
	
}
