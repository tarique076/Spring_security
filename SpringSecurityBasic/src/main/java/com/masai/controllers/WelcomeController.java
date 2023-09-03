package com.masai.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("welcome")
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome without security", HttpStatus.OK);
	}
	
	@GetMapping("welcome/secured")
	public ResponseEntity<String> welcomeSecured(){
		return new ResponseEntity<String>("Welcome with security", HttpStatus.OK);
	}
}
