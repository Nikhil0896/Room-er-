package com.springboot.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout)
	{
		if(error!=null)
			model.addAttribute("error", "your username and password is invalid");
		if(logout!=null)
			model.addAttribute("message", "you have been logged out successfully");
		
		return "login";
	}
	
	
	@RequestMapping(value = {"/" , "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model)
	{
		return "welcome";
	}
	
	
	
	

}
