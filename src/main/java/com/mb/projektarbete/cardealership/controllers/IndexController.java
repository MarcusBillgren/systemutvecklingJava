package com.mb.projektarbete.cardealership.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String displayIndex() {
		return "index";
	}

}
