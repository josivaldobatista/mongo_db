package com.jfb.mongodb.repositories;

import java.util.List;

import com.jfb.mongodb.models.entities.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  List<Post> findByTitleContainingIgnoreCase(String text);
}
