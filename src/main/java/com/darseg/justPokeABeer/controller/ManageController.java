package com.darseg.justPokeABeer.controller;


import com.darseg.justPokeABeer.service.ManageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/manage")
public class ManageController {
	
	private final ManageService manageService;
	
	@PutMapping("/load")
	public void loadBars() {
		manageService.load();
	}
}
