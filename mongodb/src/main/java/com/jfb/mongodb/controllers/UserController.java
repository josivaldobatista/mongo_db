package com.jfb.mongodb.controllers;

import java.util.List;

import com.jfb.mongodb.models.DTO.UserDTO;
import com.jfb.mongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    List<UserDTO> dto = service.findAll();
    return ResponseEntity.ok().body(dto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable("id") String id) {
    UserDTO obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
