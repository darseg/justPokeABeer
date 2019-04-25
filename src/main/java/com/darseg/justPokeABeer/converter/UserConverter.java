package com.darseg.justPokeABeer.converter;

import com.darseg.justPokeABeer.dbo.UserDBO;
import com.darseg.justPokeABeer.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserConverter extends AbstractConverter<UserDBO, UserDTO> {
	
	@Override
	public UserDTO convertToDto(UserDBO userDBO) {
		final UserDTO userDTO = new UserDTO(userDBO.getName(), userDBO.getLastName());
		
		userDTO.setNickName(userDBO.getNickName());
		
		return userDTO;
	}
	
	@Override
	public UserDBO convertToDbo(UserDTO userDTO) {
		return null;
	}
}
