package com.fidelity.smallchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmallchangeController {

	@RequestMapping("/test")
	public String test() {
		
		return "working";
	}
	
}
