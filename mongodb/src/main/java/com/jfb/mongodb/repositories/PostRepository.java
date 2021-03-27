package com.jfb.mongodb.repositories;

import java.util.List;

import com.jfb.mongodb.models.entities.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);

  List<Post> findByTitleContainingIgnoreCase(String text);
}
