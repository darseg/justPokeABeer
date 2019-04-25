package com.darseg.justPokeABeer.service;

import com.darseg.justPokeABeer.converter.UserConverter;
import com.darseg.justPokeABeer.dbo.UserDBO;
import com.darseg.justPokeABeer.dto.UserDTO;
import com.darseg.justPokeABeer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private UserConverter userConverter;
	
	public UserDTO getUser(final Long id) {
		final UserDBO user = userRepository.getByUid(id);
		return userConverter.convertToDto(user);
	}
}
