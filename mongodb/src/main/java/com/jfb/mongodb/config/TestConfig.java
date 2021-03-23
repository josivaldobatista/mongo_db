package com.jfb.mongodb.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.jfb.mongodb.models.entities.User;
import com.jfb.mongodb.repositories.PostRepository;
import com.jfb.mongodb.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @PostConstruct
  public void init() {
    userRepository.deleteAll(); // <- Para sempre que rodar o sitema ter um banco zerado.
    postRepository.deleteAll();

    // USERS
    User maria = new User(null, "Maria Brow", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Gray", "bob@gmail.com");
    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    // POSTS
    

  }
}
