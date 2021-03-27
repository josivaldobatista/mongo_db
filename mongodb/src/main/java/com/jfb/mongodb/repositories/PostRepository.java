package com.jfb.mongodb.repositories;

import java.time.Instant;
import java.util.List;

import com.jfb.mongodb.models.entities.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

  @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
  List<Post> searchTitle(String text);

  @Query("{ $and: [ {'moment': { $gte: ?1} }, {'moment': { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } } , { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
  List<Post> fullSearch(String text, Instant startMoment, Instant endMoment);

  List<Post> findByTitleContainingIgnoreCase(String text);

  // ABAIXO ESTÁ COMO MONTEI A QUERY 'fullSearch' BASEANDO-ME NA DOCUMENTAÇÃO DO MONGO
  // https://docs.mongodb.com/manual/reference/operator/query/

  // FINAL
  // { $and: [ {'moment': { $gte: ?1} }, {'moment': { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } } , { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }

  //PASSO A PASSO
  // {moment: { $gte: ?1} }

  // {moment: { $lte: ?2} }

  // { 'title': { $regex: ?0, $options: 'i' } }

  // { 'body': { $regex: ?0, $options: 'i' } }

  // { 'comments.text': { $regex: ?0, $options: 'i' } }

  // { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } } , { 'comments.text': { $regex: ?0, $options: 'i' } } ] }

}
