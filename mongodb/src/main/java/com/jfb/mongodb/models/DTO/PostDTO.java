package com.jfb.mongodb.models.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.jfb.mongodb.models.embedded.Author;
import com.jfb.mongodb.models.embedded.Comment;
import com.jfb.mongodb.models.entities.Post;

public class PostDTO {

  private String id;
  private Instant moment;
  private String title;
  private String body;
  private Author author;
  private List<Comment> comments = new ArrayList<>();

  public PostDTO() {
  }

  public PostDTO(String id, Instant moment, String title, String body, Author author) {
    this.id = id;
    this.moment = moment;
    this.title = title;
    this.body = body;
    this.author = author;
  }

  public PostDTO(Post entity) {
    id = entity.getId();
    moment = entity.getMoment();
    title = entity.getTitle();
    body = entity.getBody();
    author = entity.getAuthor();
    comments.addAll(entity.getComments());
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Instant getMoment() {
    return this.moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Author getAuthor() {
    return this.author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Comment> getComments() {
    return this.comments;
  }

}
