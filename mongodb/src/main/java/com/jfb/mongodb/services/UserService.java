package com.jfb.mongodb.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jfb.mongodb.models.DTO.UserDTO;
import com.jfb.mongodb.models.entities.User;
import com.jfb.mongodb.repositories.UserRepository;
import com.jfb.mongodb.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public UserDTO findById(String id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Objecto não encontrado"));
		return new UserDTO(entity);
	}
}
