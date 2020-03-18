package com.apiconsumer.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class LoggedUser {
	private LoggedUser() {
	    throw new IllegalStateException("Utility/Common class Can Not Be instantiated");
	  }

	public static String loggedInUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} else {
			return principal.toString();
		}

	}
}
