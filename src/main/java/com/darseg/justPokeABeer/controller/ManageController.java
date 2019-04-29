package com.darseg.justPokeABeer.controller;


import com.darseg.justPokeABeer.service.ManageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/manage")
public class ManageController {
	
	private final ManageService manageService;
	
	@PutMapping("/load")
	public void loadHotels() {
		manageService.load();
	}
}
