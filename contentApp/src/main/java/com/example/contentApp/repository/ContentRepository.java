package com.example.contentApp.repository;

import com.example.contentApp.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends MongoRepository<Content,Integer> {
}
