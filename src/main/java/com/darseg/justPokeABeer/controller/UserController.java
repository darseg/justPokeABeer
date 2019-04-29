package com.darseg.justPokeABeer.controller;

import com.darseg.justPokeABeer.dto.UserDTO;
import com.darseg.justPokeABeer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") long id) {
		final UserDTO user = userService.getUser(id);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
