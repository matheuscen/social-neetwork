package br.com.social.neetwork.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.social.neetwork.dto.UserDTO;
import br.com.social.neetwork.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO request) {
		
		this.userService.saveUser(request);
		
		return ResponseEntity.created(URI.create("")).build();
	}

}
