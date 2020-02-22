package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//hace una nueva peticiòn, se pierden los request
//	@GetMapping("/")
//	public String home() {
//		return "redirect:/app/index";
//	}
	
	//request se mantiene, no se reinicia
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}
	
//	@GetMapping("/")
//	public String home() {
//		return "redirect:https://google.com";
//	}
}
