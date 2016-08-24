package com.example.controller;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/handleLogin", method = RequestMethod.POST)
	public String loginHandler(){
		if(checkUserHasAutority("ROLE_ADMIN"))			// Check User is Admin
			return "redirect:/admin/home";
		else if(checkUserHasAutority("ROLE_VOLUNTEER"))	// Check User is Volunteer
			return "redirect:/volunteer";	
		else
			return "redirect:/login";					// Redirect to Login
    }
	
	@SuppressWarnings("unchecked")
	public boolean checkUserHasAutority(String authority){	
		List<GrantedAuthority> listAuthorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : listAuthorities) {
            if (authority.equals(grantedAuthority.getAuthority())) {
                return true;
            }
        }
		return false;
	}
    
}
