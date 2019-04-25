package com.darseg.justPokeABeer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
	private String name;
	
	private String lastName;
	
	private String nickName;
	
	public UserDTO(final String name, final String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
}