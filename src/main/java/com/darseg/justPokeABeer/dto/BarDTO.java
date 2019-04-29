package com.darseg.justPokeABeer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BarDTO {
	
	private String code;
	
	private String name;
	
	private String address;
	
	private String phones;
	
	public BarDTO(final String code) {
		this.code = code;
	}
}
