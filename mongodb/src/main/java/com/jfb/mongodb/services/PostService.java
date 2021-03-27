package com.jfb.mongodb.services;

import java.util.Optional;

import com.jfb.mongodb.models.DTO.PostDTO;
import com.jfb.mongodb.models.entities.Post;
import com.jfb.mongodb.repositories.PostRepository;
import com.jfb.mongodb.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public PostDTO findById(String id) {
		Post entity = getEntityById(id);
		return new PostDTO(entity);
	}

	private Post getEntityById(String id) {
		Optional<Post> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
	}
}
