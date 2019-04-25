package com.darseg.justPokeABeer.controller;

import com.darseg.justPokeABeer.dto.UserDTO;
import com.darseg.justPokeABeer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") long id) {
		final UserDTO user = userService.getUser(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
