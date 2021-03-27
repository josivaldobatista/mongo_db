package com.jfb.mongodb.controllers;

import com.jfb.mongodb.models.DTO.PostDTO;
import com.jfb.mongodb.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private PostService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<PostDTO> findById(@PathVariable("id") String id) {
    PostDTO obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
