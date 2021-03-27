package com.jfb.mongodb.services;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	public List<PostDTO> findByTitle(String text) {
		List<Post> list = repository.searchTitle(text);
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

	public List<PostDTO> fullSearch(String text, String start, String end) {
		Instant startMoment = converterMoment(start, Instant.ofEpochMilli(0L));
		Instant endMoment = converterMoment(end, Instant.now());

		List<Post> list = repository.fullSearch(text, startMoment, endMoment);
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

	private Post getEntityById(String id) {
		Optional<Post> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
	}

	private Instant converterMoment(String originalString, Instant alternative) {
		try {
			return Instant.parse(originalString);
		} catch (DateTimeParseException e) {
			return alternative;
		}
	}

}
