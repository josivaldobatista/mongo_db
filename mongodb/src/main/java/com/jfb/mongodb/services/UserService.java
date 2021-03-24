package com.jfb.mongodb.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jfb.mongodb.models.DTO.UserDTO;
import com.jfb.mongodb.models.entities.User;
import com.jfb.mongodb.repositories.UserRepository;

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
}
