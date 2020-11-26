package com.leofaria.projectst.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/home")
	public String HomePage(Model model) {
		model.addAttribute("message", "Hello World");
		return "home";
	}

}
