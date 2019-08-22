package com.darseg.justPokeABeer.controller;


import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.service.BarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/bar")
public class BarController {
    private final BarService barService;

    @GetMapping("/{id}")
    public ResponseEntity<BarDTO> getBar(@PathVariable("id") Long id) {
        final BarDTO bar = barService.getBar(id);

        return new ResponseEntity<>(bar, HttpStatus.OK);
    }
}
